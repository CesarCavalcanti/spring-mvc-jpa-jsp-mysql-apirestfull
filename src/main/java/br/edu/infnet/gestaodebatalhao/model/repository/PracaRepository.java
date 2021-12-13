package br.edu.infnet.gestaodebatalhao.model.repository;

import br.edu.infnet.gestaodebatalhao.model.domain.Praca;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PracaRepository extends CrudRepository<Praca,Integer> {
    List<Praca> findAllByIdNotNullOrderByCompanhiaAsc();
}
