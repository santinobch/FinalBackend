package com.example.demo.DataLoader;

import com.example.demo.Entities.Odontologo;
import com.example.demo.Entities.Paciente;
import com.example.demo.Entities.Turno;
import com.example.demo.Repository.IOdontologoRepository;
import com.example.demo.Repository.IPacienteRepository;
import com.example.demo.Repository.ITurnoRespository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Component
public class DataLoader implements ApplicationRunner {

    private static final Logger logger = Logger.getLogger(DataLoader.class);

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/test";
    private final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "";

    private IOdontologoRepository odontologoRepository;
    private IPacienteRepository pacienteRepository;
    private ITurnoRespository turnoRespository;

    @Autowired
    public DataLoader(IOdontologoRepository odontologoRepository, IPacienteRepository pacienteRepository, ITurnoRespository turnoRespository) {
        this.odontologoRepository = odontologoRepository;
        this.pacienteRepository = pacienteRepository;
        this.turnoRespository = turnoRespository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Path path_ = Path.of("src/scripts/tables_init.sql");
        String file_ = null;
        try {
            file_ = Files.readString(path_);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Connection connection;
        PreparedStatement prepareStatement;
        try {
            logger.info("Ejecutando creacion de tablas");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            prepareStatement = connection.prepareStatement(file_);
            prepareStatement.executeUpdate();

            prepareStatement.close();
            logger.info("Tablas creada exitosamente");

        } catch (Exception e) {
            logger.error("Error al crear tablas: " + e.getMessage());
        }

        //Llenando tablas de datos
        Odontologo Od1 = new Odontologo(1000, "Juan", "Alfonso");
        Odontologo Od2 = new Odontologo(1001, "Gervasio", "Hernandez");

        Paciente Pac1 = new Paciente("Luisa", "Mendez", "La Cuenca 302", 12421343, Timestamp.valueOf(LocalDateTime.now()));
        Paciente Pac2 = new Paciente("Jazmin", "Torcuato", "La Sienaga 7345", 12421343, Timestamp.valueOf(LocalDateTime.now()));

        try {
            logger.info("Llenando tablas con datos");

            Od1 = odontologoRepository.save(Od1);
            Od2 = odontologoRepository.save(Od2);

            Pac1 = pacienteRepository.save(Pac1);
            Pac2 =pacienteRepository.save(Pac2);

            Turno Tur1 = new Turno(Timestamp.valueOf(LocalDateTime.now()), Pac1, Od1 );
            Turno Tur2 = new Turno(Timestamp.valueOf(LocalDateTime.now()), Pac2, Od2 );

            turnoRespository.save(Tur1);
            turnoRespository.save(Tur2);

            logger.info("Data cargada");
        }
        catch (Exception e) {
            logger.error("Error cargar tablas con datos: " + e.getMessage());
        }
    }
}
