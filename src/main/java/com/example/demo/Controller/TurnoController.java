package com.example.demo.Controller;

import com.example.demo.Entities.Turno;
import com.example.demo.Services.Implementation.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;


@RestController
@RequestMapping("/appointments")
public class TurnoController {

    @Autowired
    TurnoService turnoService;

    @PostMapping("/register")
    public ResponseEntity<?> create(@RequestBody Turno turno) {
        turnoService.create(turno);
        return new ResponseEntity<>(turno, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Optional<Turno>>  findAById(@PathVariable Integer id) {
        Optional<Turno> turno = turnoService.findById(id);
        return new ResponseEntity<>(turno, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Turno turno) {
        turnoService.update(turno);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        turnoService.deleteById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/lists")
    public ResponseEntity<Collection<Turno>> findAll() {
        return ResponseEntity.ok(turnoService.findAll());
    }

}
