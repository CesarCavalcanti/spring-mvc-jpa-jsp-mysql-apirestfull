package br.edu.infnet.gestaodebatalhao.model.repository;

import br.edu.infnet.gestaodebatalhao.model.domain.Guarnicao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuarnicaoRepository extends CrudRepository<Guarnicao,Integer> {
}
