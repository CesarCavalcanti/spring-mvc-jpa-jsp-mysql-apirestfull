package br.edu.infnet.gestaodebatalhao.model.repository;

import br.edu.infnet.gestaodebatalhao.model.domain.Praca;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PracaRepository extends CrudRepository<Praca,Integer> {
}
