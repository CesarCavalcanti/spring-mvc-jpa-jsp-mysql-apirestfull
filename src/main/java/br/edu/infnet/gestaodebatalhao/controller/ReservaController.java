package br.edu.infnet.gestaodebatalhao.controller;

import br.edu.infnet.gestaodebatalhao.model.domain.Endereco;
import br.edu.infnet.gestaodebatalhao.model.domain.Praca;
import br.edu.infnet.gestaodebatalhao.model.domain.Reserva;
import br.edu.infnet.gestaodebatalhao.model.domain.Usuario;
import br.edu.infnet.gestaodebatalhao.model.service.PracaService;
import br.edu.infnet.gestaodebatalhao.model.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class ReservaController {
    @Autowired
    private ReservaService reservaService;

    @GetMapping(value = "/reserva")
    public String telaCadastro() {
        return "reserva/cadastro";
    }

    @GetMapping (value = "/reservas")
    public String telaLista(Model model) {
        model.addAttribute("lista", reservaService.obterLista());
        return "reserva/lista";
    }

    @PostMapping(value = "/reserva/incluir")
    public String incluir(Model model, Reserva reserva, @SessionAttribute("user")Usuario usuario, Endereco endereco) {

        reserva.setUsuario(usuario);
        try {
            reservaService.incluir(reserva,endereco);
        }catch (Exception e){
            model.addAttribute("mensagem", "Erro, Matricula ja utilizada pela instituição");
            return telaErro(model);
        }
        model.addAttribute("reserva",reserva);
        return telaLista(model);
    }

    @GetMapping(value = "reserva/erro")
    public String telaErro(Model model){
        return "reserva/erro";
    }

    @GetMapping (value = "/reserva/{id}/excluir")
    public String excluir (Model model,@PathVariable Integer id) {

        reservaService.excluir(id);

        return "redirect:/reservas";
    }
}
