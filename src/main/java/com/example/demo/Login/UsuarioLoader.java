package com.example.demo.Login;

import com.example.demo.DataLoader.DataLoader;
import com.example.demo.Entities.Usuario;
import com.example.demo.Repository.IUsuarioRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UsuarioLoader implements ApplicationRunner {

    private static final Logger logger = Logger.getLogger(DataLoader.class);
    private final IUsuarioRepository usuarioRepository;

    public UsuarioLoader(IUsuarioRepository userRepo) {
        this.usuarioRepository = userRepo;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("Cargando usuarios en la base");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password1 = encoder.encode("password1");
        String password2 = encoder.encode("password2");

        usuarioRepository.save(new Usuario("admin", "admin", "x@x.com", password1, UsuarioRoles.ADMIN));
        usuarioRepository.save(new Usuario("user", "user", "x@x.com", password2, UsuarioRoles.USER));

        logger.info("Se han agregado usuarios en la base");
    }

    public void login(Usuario usuario) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = encoder.encode(usuario.getPassword());
        usuario.setPassword(password);
        usuario.setRoles(UsuarioRoles.USER);
        usuarioRepository.save(usuario);
    }
}
