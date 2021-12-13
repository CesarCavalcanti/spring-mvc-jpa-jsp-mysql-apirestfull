package br.edu.infnet.gestaodebatalhao.model.service;

import br.edu.infnet.gestaodebatalhao.model.domain.PolicialMilitar;
import br.edu.infnet.gestaodebatalhao.model.repository.PolicialMilitarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicialMilitarService {

    @Autowired
    private PolicialMilitarRepository policialMilitarRepository;

    public List<PolicialMilitar> obterLista(Integer id){
        return policialMilitarRepository.findAllByBatalhaoIdOrderByCompanhiaAsc(id);
    }

    public List<PolicialMilitar> obterLista( ){
        return policialMilitarRepository.findAllByIdNotNullOrderByCompanhiaAsc();
    }

    public void excluir (Integer id) {
        policialMilitarRepository.deleteById(id);
    }

    public PolicialMilitar obterPorId(Integer id){
        return policialMilitarRepository.findById(id).orElse(null);
    }

    public long contar (){
        return policialMilitarRepository.count();
    }
}
