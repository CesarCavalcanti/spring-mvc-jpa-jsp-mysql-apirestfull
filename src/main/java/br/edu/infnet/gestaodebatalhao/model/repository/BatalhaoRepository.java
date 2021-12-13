package br.edu.infnet.gestaodebatalhao.model.repository;

import br.edu.infnet.gestaodebatalhao.model.domain.Batalhao;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatalhaoRepository extends CrudRepository<Batalhao,Integer> {

    List<Batalhao> findAllByIdNotNullOrderByAreaAsc();


}
