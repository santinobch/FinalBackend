package com.example.demo.Repository;

import com.example.demo.Entities.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITurnoRespository extends JpaRepository<Turno, Integer> {
}
