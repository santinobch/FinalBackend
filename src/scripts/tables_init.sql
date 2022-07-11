DROP TABLE IF EXISTS Turnos;
DROP TABLE IF EXISTS Odontologos;
DROP TABLE IF EXISTS Pacientes;
DROP TABLE IF EXISTS Usuarios;

CREATE TABLE Odontologos(
    id INT AUTO_INCREMENT PRIMARY KEY,
    matricula INT,
    nombre VARCHAR(255),
    apellido VARCHAR(255)
);

CREATE TABLE Pacientes(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    apellido VARCHAR(255),
    domicilio VARCHAR(255),
    DNI INT,
    fecha_alta TIME WITH TIME ZONE
);

CREATE TABLE Turnos(
    id INT AUTO_INCREMENT PRIMARY KEY,
    horario TIMESTAMP WITH TIME ZONE,
    odontologo_id INT,
    paciente_id INT,
    CONSTRAINT FK_TURNO_ODONTOLOGO foreign key (odontologo_id) references Odontologos(id),
    CONSTRAINT FK_TURNO_PACIENTE foreign key (paciente_id) references Pacientes(id)
);

CREATE TABLE Usuarios(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    username VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    role VARCHAR(255)
);