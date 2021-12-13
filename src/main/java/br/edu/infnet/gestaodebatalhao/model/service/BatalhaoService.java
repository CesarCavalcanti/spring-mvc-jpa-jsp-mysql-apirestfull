package br.edu.infnet.gestaodebatalhao.model.service;

import br.edu.infnet.gestaodebatalhao.model.domain.Batalhao;
import br.edu.infnet.gestaodebatalhao.model.domain.Endereco;
import br.edu.infnet.gestaodebatalhao.model.repository.BatalhaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatalhaoService {

    @Autowired
    private BatalhaoRepository batalhaoRepository;

    public List<Batalhao> obterLista(){

        return batalhaoRepository.findAllByIdNotNullOrderByAreaAsc();
    }

    public Batalhao findById(Integer id){
        return batalhaoRepository.findById(id).orElse(null);
    }

    public void incluir (Batalhao batalhao, Endereco endereco) {
        batalhao.setEndereco(endereco);
        batalhaoRepository.save(batalhao);
    }

    public void excluir (Integer id) {
        batalhaoRepository.deleteById(id);
    }

    public long contar (){
        return batalhaoRepository.count();
    }
}
