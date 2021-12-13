package br.edu.infnet.gestaodebatalhao.model.service;

import br.edu.infnet.gestaodebatalhao.model.domain.Endereco;
import br.edu.infnet.gestaodebatalhao.model.domain.Oficial;
import br.edu.infnet.gestaodebatalhao.model.domain.Praca;
import br.edu.infnet.gestaodebatalhao.model.domain.Usuario;
import br.edu.infnet.gestaodebatalhao.model.repository.EnderecoRepository;
import br.edu.infnet.gestaodebatalhao.model.repository.OficialRepository;
import br.edu.infnet.gestaodebatalhao.model.repository.PracaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PracaService {

    @Autowired
    private PracaRepository pracaRepository;




    public List<Praca> obterLista(){
        return pracaRepository.findAllByIdNotNullOrderByPatente();
    }

    public void incluir (Praca praca, Endereco endereco) {
        praca.setEndereco(endereco);
        pracaRepository.save(praca);
    }

    public void excluir (Integer id) {
        pracaRepository.deleteById(id);
    }

    public long contar (){
        return pracaRepository.count();
    }
}
