USE proyectofinal;

-- Crear la tabla Login
CREATE TABLE Login (
    id INT PRIMARY KEY AUTO_INCREMENT,
    NombreLogin VARCHAR(50),
    ContrasenaLogin VARCHAR(50),
    tipoUsuario INT 
);

-- Crear el procedimiento almacenado SPVerificarCredenciales
DELIMITER $$

CREATE PROCEDURE SPVerificarCredenciales(
    IN p_nombreUsuario VARCHAR(50),
    IN p_contrasena VARCHAR(50)
)
BEGIN
    SELECT id, NombreLogin, tipoUsuario
    FROM Login
    WHERE NombreLogin = p_nombreUsuario AND ContrasenaLogin = p_contrasena;
END $$

DELIMITER ;

CREATE TABLE Alumno (
	IdAlumno INT AUTO_INCREMENT PRIMARY KEY,
	NombreAlumno VARCHAR (20),
    ApellidoAlumno VARCHAR (20),
	ClaveAlumno INT (3)
);

CREATE TABLE Notas1Unidad (
	IdNota1Unidad INT auto_increment PRIMARY KEY,
	IdAlumno INT,
    Nota1Lenguaje INT (3),
    Nota1Ingles INT (3),
    Nota1Kaqchikel INT (3),
    Nota1Matematicas INT (3),
    Nota1Naturales INT (3),
    FOREIGN KEY (IdAlumno) REFERENCES Alumno(IdAlumno) 
);

create procedure InsertarAlumno(
	IN NombreAlumno VARCHAR (20),
    IN ApellidoAlumno VARCHAR (20),
	IN ClaveAlumno INT (3)
)
INSERT INTO Alumno (NombreAlumno, ApellidoAlumno, ClaveAlumno)
VALUES (NombreAlumno, ApellidoAlumno, ClaveAlumno);

--
CREATE PROCEDURE LeerAlumno()
    SELECT ClaveAlumno, NombreAlumno, ApellidoAlumno FROM alumno;

    
--
CREATE PROCEDURE ActualizarAlumno(
    IN pClaveAlumno INT(3),
    IN pNombreAlumno VARCHAR(20),
    IN pApellidoAlumno VARCHAR(20)
)
    UPDATE Alumno
    SET NombreAlumno = pNombreAlumno, ApellidoAlumno = pApellidoAlumno
    WHERE ClaveAlumno = pClaveAlumno;
--

CREATE PROCEDURE EliminarAlumno(
    IN pClaveAlumno INT(3)
)
    DELETE FROM Alumno WHERE ClaveAlumno = pClaveAlumno;

CREATE PROCEDURE ListarAlumnos()
	SELECT IdAlumno, NombreAlumno, ApellidoAlumno, ClaveAlumno from alumno;

SELECT * FROM alumno;
SELECT * FROM Alumno;

INSERT INTO login (NombreLogin, ContrasenaLogin, tipoUsuario)
VALUES ('byron641', 'Guatemala.2024', 1); 

INSERT INTO Alumno (NombreAlumno, ApellidoAlumno, ClaveAlumno)
VALUES ('Jose', 'Perez', 1);
	

