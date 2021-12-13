package br.edu.infnet.gestaodebatalhao.model.service;

import br.edu.infnet.gestaodebatalhao.model.domain.Usuario;
import br.edu.infnet.gestaodebatalhao.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario autenticacao (String email, String senha){
        return usuarioRepository.autenticacao(email, senha);
    }
    public void incluir (Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public List<Usuario> usuarioList(){
        return usuarioRepository.findAllByIdNotNullOrderByNomeAsc();
    }

    public void excluir (Integer id) {
        usuarioRepository.deleteById(id);
    }

    public long contar (){
        return usuarioRepository.count();
    }
}
