package com.example.demo.Controller;

import com.example.demo.Entities.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@RestController
public class UsuarioController {
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<?> user() throws Exception{
        UserDetails userDatails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Usuario user = new Usuario();
        user.setName(userDatails.getUsername());
        return ResponseEntity.ok(user);
    }
}