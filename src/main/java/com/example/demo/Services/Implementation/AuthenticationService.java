package com.example.demo.Services.Implementation;

import com.example.demo.Entities.Usuario;
import com.example.demo.Login.UsuarioRoles;
import com.example.demo.Repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AuthenticationService implements UserDetailsService {
    @Autowired
    IUsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Usuario> user = usuarioRepository.getUserByName(userName);
        Set<GrantedAuthority> autorizaciones = new HashSet<>();
        GrantedAuthority autorizacion = null;

        for (UsuarioRoles rol : user.get().getRoles()) {
            autorizacion = new SimpleGrantedAuthority(rol.getName());
            autorizaciones.add(autorizacion);
        }
        org.springframework.security.core.userdetails.User userDetail = new org.springframework.security.core.userdetails.User( user.get().getName(), "{noop}" + user.get().getPassword(), true, true, true,true, autorizaciones);
        return userDetail;
    }
}