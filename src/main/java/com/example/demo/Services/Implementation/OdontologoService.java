package com.example.demo.Services.Implementation;

import com.example.demo.Entities.Odontologo;
import com.example.demo.Repository.IOdontologoRepository;
import com.example.demo.Services.IOdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService implements IOdontologoService {

    @Autowired
    private IOdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public Optional<Odontologo> findById(Integer id) {
        return odontologoRepository.findById(id);
    }

    @Override
    public Odontologo create(Odontologo odontologo) {
       return odontologoRepository.save(odontologo);
    }

    @Override
    public void deleteById(Integer id) {
        odontologoRepository.deleteById(id);
    }

    @Override
    public Odontologo update(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);
    }

    @Override
    public List<Odontologo> findAll() {
        return odontologoRepository.findAll();
    }
}
