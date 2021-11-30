package br.edu.infnet.gestaodebatalhao;

import br.edu.infnet.gestaodebatalhao.model.domain.Usuario;
import br.edu.infnet.gestaodebatalhao.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class UsuarioLoader implements ApplicationRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Usuario usuario = new Usuario();
        usuario.setEmail("bangjogos1@gmail.com");
        usuario.setNome("Cesar de sena");
        usuario.setSenha("123");
        usuario.setAdmin(true);
        usuarioRepository.save(usuario);
    }
}
