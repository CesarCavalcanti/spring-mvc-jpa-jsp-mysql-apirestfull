package br.edu.infnet.gestaodebatalhao.controller;

import br.edu.infnet.gestaodebatalhao.model.domain.Endereco;
import br.edu.infnet.gestaodebatalhao.model.domain.Oficial;
import br.edu.infnet.gestaodebatalhao.model.domain.Usuario;
import br.edu.infnet.gestaodebatalhao.model.service.OficialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class OficialController {
    
    @Autowired
    private OficialService oficialService;

    @GetMapping(value = "/oficial")
    public String telaCadastro() {
        return "oficial/cadastro";
    }

    @GetMapping (value = "/oficiais")
    public String telaLista(Model model) {
        model.addAttribute("lista", oficialService.obterLista());
        return "oficial/lista";
    }
    @GetMapping(value = "oficial/erro")
    public String telaErro(Model model){
        return "oficial/erro";
    }

    @PostMapping(value = "/oficial/incluir")
    public String incluir(Model model, Oficial oficial, @SessionAttribute("user")Usuario usuario, Endereco endereco) {

        oficial.setUsuario(usuario);
        try {
            oficialService.incluir(oficial,endereco);
        }catch (Exception e){
            model.addAttribute("mensagem", "Erro! Matricula já utilizada pela instituição");
            return telaErro(model);
        }


        model.addAttribute("oficial",oficial);
        return telaLista(model);
    }

    @GetMapping (value = "/oficial/{id}/excluir")
    public String excluir (Model model,@PathVariable Integer id) {

        oficialService.excluir(id);

        return "redirect:/oficiais";
    }
    
}
