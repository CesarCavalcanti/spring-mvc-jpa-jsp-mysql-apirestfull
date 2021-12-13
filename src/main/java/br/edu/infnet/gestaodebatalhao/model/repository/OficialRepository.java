package br.edu.infnet.gestaodebatalhao.model.repository;

import br.edu.infnet.gestaodebatalhao.model.domain.Oficial;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OficialRepository extends CrudRepository<Oficial,Integer> {

    List<Oficial> findAllByIdNotNullOrderByCompanhiaAsc();
}
