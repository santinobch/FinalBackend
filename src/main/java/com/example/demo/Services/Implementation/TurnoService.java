package com.example.demo.Services.Implementation;

import com.example.demo.Entities.Turno;
import com.example.demo.Repository.ITurnoRespository;
import com.example.demo.Services.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService implements ITurnoService {

    @Autowired
    private ITurnoRespository turnoRepository;

    @Autowired
    ObjectMapper objectMapper;


    @Override
    public Optional<Turno> findById(Integer id) {
        Optional<Turno> turno = turnoRepository.findById(id);
        return turno;
    }

    @Override
    public Turno create(Turno turno) {
        turno = turnoRepository.save(turno);
        return turno;
    }

    @Override
    public void deleteById(Integer id) {
        turnoRepository.deleteById(id);
    }

    @Override
    public Turno update(Turno turno) {
        turno = turnoRepository.save(turno);
        return turno;
    }

    @Override
    public List<Turno> findAll() {
        List<Turno> turnos = turnoRepository.findAll();
        return turnos;
    }
}
