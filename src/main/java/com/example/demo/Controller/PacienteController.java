package com.example.demo.Controller;

import com.example.demo.Entities.Paciente;
import com.example.demo.Services.Implementation.PacienteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;


@AllArgsConstructor
@RestController
@RequestMapping("/patients")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @PostMapping("/register")
    public ResponseEntity<?> create (@RequestBody Paciente paciente) {
        pacienteService.create(paciente);
        return ResponseEntity.ok(HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Paciente>> findById(@PathVariable Integer id) {
        Optional<Paciente> paciente  = pacienteService.findById(id);
        return new ResponseEntity<>(paciente, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update (@RequestBody Paciente paciente) {
        pacienteService.update(paciente);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable Integer id) {
        pacienteService.deleteById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/lists")
    public Collection<Paciente> findAll() {
        return pacienteService.findAll();

    }
}



