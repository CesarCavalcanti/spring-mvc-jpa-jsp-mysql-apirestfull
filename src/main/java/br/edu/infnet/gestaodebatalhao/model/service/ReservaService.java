package br.edu.infnet.gestaodebatalhao.model.service;

import br.edu.infnet.gestaodebatalhao.model.domain.Endereco;
import br.edu.infnet.gestaodebatalhao.model.domain.Reserva;
import br.edu.infnet.gestaodebatalhao.model.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reserva> obterLista(){
        return reservaRepository.findAllByIdNotNullOrderByPatente();
    }

    public void incluir (Reserva reserva, Endereco endereco) {
        reserva.setEndereco(endereco);
        reservaRepository.save(reserva);
    }

    public void excluir (Integer id) {
        reservaRepository.deleteById(id);
    }

    public long contar (){
        return reservaRepository.count();
    }
}
