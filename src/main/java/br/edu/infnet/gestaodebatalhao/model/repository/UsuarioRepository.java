package br.edu.infnet.gestaodebatalhao.model.repository;

import br.edu.infnet.gestaodebatalhao.model.domain.Usuario;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario,Integer> {
     @Query("from Usuario u where u.email =:email and u.senha =:senha")
     Usuario autenticacao (String email, String senha);

     List<Usuario> findAllByIdNotNullOrderByNomeAsc();
}
