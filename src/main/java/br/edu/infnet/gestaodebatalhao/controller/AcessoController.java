package br.edu.infnet.gestaodebatalhao.controller;

import br.edu.infnet.gestaodebatalhao.model.domain.Usuario;
import br.edu.infnet.gestaodebatalhao.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

@SessionAttributes("user")
@Controller
public class AcessoController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value = "/")
    public String telaIndex() {
        return "index";
    }

    @GetMapping(value = "/login")
    public String telaLogin() {
        return "login";
    }

    @GetMapping(value = "/logout")
    public String telaLogout(HttpSession session, SessionStatus status) {
        status.setComplete();

        session.removeAttribute("user");

        return "redirect:/";
    }

    @PostMapping(value = "/login")
    public String telaIndex(Model model, @RequestParam String email, String senha) {

        Usuario usuario = usuarioService.autenticacao(email, senha);

        if(usuario != null){
            model.addAttribute("user",usuario);
            return "index";
        }else {
            model.addAttribute("msg", "Erro... email ou senha inválidos!");

            return "login";
        }


    }
}
