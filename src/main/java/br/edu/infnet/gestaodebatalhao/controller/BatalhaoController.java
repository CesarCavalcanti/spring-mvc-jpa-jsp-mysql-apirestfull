package br.edu.infnet.gestaodebatalhao.controller;

import br.edu.infnet.gestaodebatalhao.model.domain.Batalhao;
import br.edu.infnet.gestaodebatalhao.model.domain.Endereco;
import br.edu.infnet.gestaodebatalhao.model.domain.PolicialMilitar;
import br.edu.infnet.gestaodebatalhao.model.service.BatalhaoService;
import br.edu.infnet.gestaodebatalhao.model.service.PolicialMilitarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BatalhaoController {

    @Autowired
    private PolicialMilitarService policialMilitarService;
    @Autowired
    private BatalhaoService batalhaoService;


    @GetMapping(value = "/batalhao")
    public String telaCadastro(Model model) {

        model.addAttribute("policiais", policialMilitarService.obterLista());
        return "batalhao/cadastro";
    }

    @GetMapping (value = "/batalhoes")
    public String telaLista(Model model) {
        model.addAttribute("lista", batalhaoService.obterLista());
        return "batalhao/lista";
    }

    @PostMapping(value = "/batalhao/incluir")
    public String incluir(Model model, Batalhao batalhao, Endereco endereco, @RequestParam String[]policiaisIds) {

        List<PolicialMilitar> listaPoliciais = new ArrayList<PolicialMilitar>();
        for(String idPolicial : policiaisIds){
            PolicialMilitar policialMilitar = policialMilitarService.obterPorId(Integer.valueOf(idPolicial));
            listaPoliciais.add(policialMilitar);
        }
        batalhao.setPoliciais(listaPoliciais);
        try {
            batalhaoService.incluir(batalhao,endereco);
        }catch (Exception e){
            model.addAttribute("mensagem", "Área indisponível!!");
            return telaErro(model);
        }
        model.addAttribute("batalhao",batalhao);

        return telaLista(model);
    }
    @GetMapping(value = "batalhao/erro")
    public String telaErro(Model model){
        return "batalhao/erro";
    }

    @GetMapping (value = "/batalhao/{id}/excluir")
    public String excluir (Model model,@PathVariable Integer id) {

        batalhaoService.excluir(id);

        return "redirect:/batalhoes";
    }
    @GetMapping (value = "/batalhao/{id}/buscar")
    public String listaPms(Model model,@PathVariable Integer id){
        model.addAttribute("policiais",policialMilitarService.obterLista(id));
        return "batalhao/policiaislista";
    }


}
