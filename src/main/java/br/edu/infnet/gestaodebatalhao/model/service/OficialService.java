package br.edu.infnet.gestaodebatalhao.model.service;

import br.edu.infnet.gestaodebatalhao.model.domain.Endereco;
import br.edu.infnet.gestaodebatalhao.model.domain.Oficial;
import br.edu.infnet.gestaodebatalhao.model.domain.Usuario;
import br.edu.infnet.gestaodebatalhao.model.repository.EnderecoRepository;
import br.edu.infnet.gestaodebatalhao.model.repository.OficialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OficialService {

    @Autowired
    private OficialRepository oficialRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Oficial> obterLista(){

        return (List<Oficial>)oficialRepository.findAll();
    }

    public List<Oficial> obterLista(Usuario usuario){
        return (List<Oficial>)oficialRepository.obterLista(usuario.getId());
    }

    public void incluir (Oficial oficial, Endereco endereco) {
        oficial.setEndereco(endereco);
        oficialRepository.save(oficial);
    }

    public void excluir (Integer id) {
        oficialRepository.deleteById(id);
    }
}
