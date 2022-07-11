package com.example.demo.Services.Implementation;

import com.example.demo.Repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {
    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(IUsuarioRepository IUsuarioRepository) {
        this.usuarioRepository = IUsuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return usuarioRepository.findByEmail(email).orElseThrow( () -> new UsernameNotFoundException("User email not found"));
    }
    @Bean
    public UserDetailsService userDetailsService(IUsuarioRepository IUsuarioRepository) {
        return new UsuarioService(IUsuarioRepository);
    }
}
