package br.edu.infnet.gestaodebatalhao.controller;

import br.edu.infnet.gestaodebatalhao.model.domain.Usuario;
import br.edu.infnet.gestaodebatalhao.model.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@SessionAttributes("user")
@Controller
public class AcessoController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private BatalhaoService batalhaoService;
    @Autowired
    private OficialService oficialService;
    @Autowired
    private PracaService pracaService;
    @Autowired
    private ReservaService reservaService;
    @Autowired
    private PolicialMilitarService policialMilitarService;


    @GetMapping(value = "/")
    public String telaIndex() {
        return "login";
    }
    @GetMapping(value = "/index")
    public String telaIndexx(){
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
    @GetMapping ("/gestaobpm")
    public String gestaobpm (Model model){
        Map<String,Long> mapgestao = new HashMap<String,Long>();
        mapgestao.put("Usuarios", usuarioService.contar());
        mapgestao.put("Batalhoes", batalhaoService.contar());
        mapgestao.put("Oficiais", oficialService.contar());
        mapgestao.put("Pracas", pracaService.contar());
        mapgestao.put("Reservas", reservaService.contar());
        mapgestao.put("Policiais", policialMilitarService.contar());

        model.addAttribute("mapa",mapgestao);

        return "gestaobpm";
    }
}
