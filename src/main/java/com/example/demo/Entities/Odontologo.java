package com.example.demo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "Dentistas")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Odontologo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer matricula;
    private String nombre;
    private String apellido;

    // Relaciones
    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Turno> turno;

    public Odontologo(Integer _matricula, String _nombre, String _apellido) {
        this.matricula = _matricula;
        this.nombre = _nombre;
        this.apellido = _apellido;
    }

    //Sobrecarga
    public Odontologo(Long _id, Integer _matricula, String _nombre, String _apellido) {
        this.id = _id;
        this.matricula = _matricula;
        this.nombre = _nombre;
        this.apellido = _apellido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Set<Turno> getTurno() {
        return turno;
    }

    public void setTurno(Set<Turno> turno) {
        this.turno = turno;
    }
}
