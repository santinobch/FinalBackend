package com.example.demo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Set;


@Data
@Entity
@Table(name = "Pacientes")
@NoArgsConstructor
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;
    private String apellido;
    private String domicilio;
    private int DNI;
    private Timestamp fecha_alta;

    // Relaciones
    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Turno> turno;

    public Paciente(String _nombre, String _apellido, String _domicilio, int _DNI, Timestamp _fecha_alta) {
        this.nombre = _nombre;
        this.apellido = _apellido;
        this.domicilio = _domicilio;
        this.DNI = _DNI;
        this.fecha_alta = _fecha_alta;
    }

    //Sobrecarga
    public Paciente(Long _id, String _nombre, String _apellido, String _domicilio, int _DNI, Timestamp _fecha_alta) {
        this.id = _id;
        this.nombre = _nombre;
        this.apellido = _apellido;
        this.domicilio = _domicilio;
        this.DNI = _DNI;
        this.fecha_alta = _fecha_alta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public Timestamp getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(Timestamp fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public Set<Turno> getTurno() {
        return turno;
    }

    public void setTurno(Set<Turno> turno) {
        this.turno = turno;
    }
}
