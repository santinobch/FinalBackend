package com.example.demo.Controller;

import com.example.demo.Entities.Odontologo;
import com.example.demo.Services.Implementation.OdontologoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/dentists")
public class OdontologoController {

    @Autowired
    private final OdontologoService odontologoService;

    @PostMapping("/register")
    public ResponseEntity<?> create(@RequestBody Odontologo odontologo) {
        odontologoService.create(odontologo);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Odontologo>> findById( @PathVariable Integer id) {
        Optional<Odontologo> odontologo = odontologoService.findById(id);
        return new ResponseEntity<>(odontologo, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Odontologo odontologo) {
        odontologoService.update(odontologo);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        odontologoService.deleteById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/lists")
    public Collection<Odontologo> findAll() {
        return odontologoService.findAll();
    }
}
