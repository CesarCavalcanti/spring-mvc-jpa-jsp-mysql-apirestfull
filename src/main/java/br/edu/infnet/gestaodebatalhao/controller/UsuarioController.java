package br.edu.infnet.gestaodebatalhao.controller;

import br.edu.infnet.gestaodebatalhao.model.domain.Usuario;
import br.edu.infnet.gestaodebatalhao.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value = "/usuario")
    public String telaCadastro() {
        return "usuario/cadastro";
    }

    @PostMapping(value = "/usuario/incluir")
    public String incluir(Model model, Usuario usuario) {
        model.addAttribute("nome",usuario.getNome());
        usuarioService.incluir(usuario);
        return "index";
    }

    @GetMapping(value = "/usuarios")
    public String listaUsuarios(Model model){
        model.addAttribute("lista",usuarioService.usuarioList());
        return "usuario/lista";
    }

    @GetMapping (value = "/usuario/{id}/excluir")
    public String excluir (Model model,@PathVariable Integer id) {

        usuarioService.excluir(id);

        return "redirect:/usuarios";
    }

}
