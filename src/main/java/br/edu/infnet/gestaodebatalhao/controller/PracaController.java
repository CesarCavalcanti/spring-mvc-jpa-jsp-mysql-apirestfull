package br.edu.infnet.gestaodebatalhao.controller;

import br.edu.infnet.gestaodebatalhao.model.domain.Endereco;
import br.edu.infnet.gestaodebatalhao.model.domain.Oficial;
import br.edu.infnet.gestaodebatalhao.model.domain.Praca;
import br.edu.infnet.gestaodebatalhao.model.domain.Usuario;
import br.edu.infnet.gestaodebatalhao.model.service.OficialService;
import br.edu.infnet.gestaodebatalhao.model.service.PracaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class PracaController {

    @Autowired
    private PracaService pracaService;

    @GetMapping(value = "/praca")
    public String telaCadastro() {
        return "praca/cadastro";
    }

    @GetMapping (value = "/pracas")
    public String telaLista(Model model) {
        model.addAttribute("lista", pracaService.obterLista());
        return "praca/lista";
    }

    @PostMapping(value = "/praca/incluir")
    public String incluir(Model model, Praca praca, @SessionAttribute("user")Usuario usuario, Endereco endereco) {

        praca.setUsuario(usuario);
        try {
            pracaService.incluir(praca,endereco);
        }catch (Exception e){
            model.addAttribute("mensagem", "Erro, Matricula ja utilizada pela instituição");
            return telaErro(model);
        }

        model.addAttribute("praca",praca);
        return telaLista(model);
    }

    @GetMapping(value = "praca/erro")
    public String telaErro(Model model){
        return "praca/erro";
    }

    @GetMapping (value = "/praca/{id}/excluir")
    public String excluir (Model model,@PathVariable Integer id) {

        pracaService.excluir(id);

        return "redirect:/pracas";
    }
}
