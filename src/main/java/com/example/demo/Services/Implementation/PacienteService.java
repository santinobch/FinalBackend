package com.example.demo.Services.Implementation;


import com.example.demo.Entities.Paciente;
import com.example.demo.Repository.IPacienteRepository;
import com.example.demo.Services.IPacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService implements IPacienteService {

    @Autowired
    private IPacienteRepository pacienteRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public Optional<Paciente> findById(Integer id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        return paciente;
    }

    @Override
    public Paciente create(Paciente paciente) {
        paciente = pacienteRepository.save(paciente);
        return paciente;
    }

    @Override
    public void deleteById(Integer id) {
        pacienteRepository.deleteById(id);
    }

    @Override
    public Paciente update(Paciente paciente) {
        paciente = pacienteRepository.save(paciente);
        return paciente;
    }

    @Override
    public List<Paciente> findAll() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        return pacientes;
    }
}
