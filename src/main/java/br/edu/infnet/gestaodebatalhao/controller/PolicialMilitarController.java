package br.edu.infnet.gestaodebatalhao.controller;

import br.edu.infnet.gestaodebatalhao.model.service.BatalhaoService;
import br.edu.infnet.gestaodebatalhao.model.service.PolicialMilitarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PolicialMilitarController {

    @Autowired
    private PolicialMilitarService policialMilitarService;

    @GetMapping (value = "/policiais")
    public String telaLista(Model model) {
        model.addAttribute("policiais",policialMilitarService.obterLista());
        return "policialmilitar/lista";
    }


    @GetMapping (value = "/policial/{id}/excluir")
    public String excluir (Model model,@PathVariable Integer id) {

        policialMilitarService.excluir(id);

        return "redirect:/policiais";
    }
}
