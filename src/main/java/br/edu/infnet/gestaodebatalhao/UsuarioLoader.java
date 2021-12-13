package br.edu.infnet.gestaodebatalhao;

import br.edu.infnet.gestaodebatalhao.model.domain.*;
import br.edu.infnet.gestaodebatalhao.model.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsuarioLoader implements ApplicationRunner {

    @Autowired
    UsuarioRepository usuarioRepository;
    OficialRepository oficialRepository;
    PracaRepository pracaRepository;
    ReservaRepository reservaRepository;
    BatalhaoRepository batalhaoRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<PolicialMilitar> list = new ArrayList<>();

        Usuario usuario = new Usuario();
        usuario.setEmail("bangjogos1@gmail.com");
        usuario.setNome("Cesar de sena");
        usuario.setSenha("123");
        usuario.setAdmin(true);
        usuarioRepository.save(usuario);



    }
}
