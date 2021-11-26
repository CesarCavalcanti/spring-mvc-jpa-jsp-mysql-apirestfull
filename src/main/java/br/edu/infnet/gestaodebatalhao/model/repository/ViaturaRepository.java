package br.edu.infnet.gestaodebatalhao.model.repository;

import br.edu.infnet.gestaodebatalhao.model.domain.Viatura;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViaturaRepository extends CrudRepository<Viatura,Integer> {
}
