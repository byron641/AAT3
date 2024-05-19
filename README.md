# AAT3

Proyecto Final de Actividad de Aprendizaje de Trabajo AAT3.

LoginView (Funcionado)

![LoginView](https://github.com/byron641/AAT3/blob/main/app/src/main/resources/LoginView.png)

MenuView (Funcionado) 

![MenuView](https://github.com/byron641/AAT3/blob/main/app/src/main/resources/MenuView.png)

Ingresar Alumno (Funcionado, UI/UX WIP) 

![Ingresar Alumno](https://github.com/byron641/AAT3/blob/main/app/src/main/resources/Ingresar%20Alumno.png)

Modificar Alumno

(Funcionado, UI/UX WIP) 

![Ingresar Alumno](https://github.com/byron641/AAT3/blob/main/app/src/main/resources/Modificar%20Alumno.png)

Ver Alumnos

(Funcionado, UI/UX WIP) 

![Ver Alumno](https://github.com/byron641/AAT3/blob/main/app/src/main/resources/Ver%20Alumno.png)

Eliminar Alumno

(Funcionado, Falta agregar boton de confirmar Eliminar Alumno, UI/UX WIP) 

![Eliminiar Alumno](https://github.com/byron641/AAT3/blob/main/app/src/main/resources/Elimina%20Alumno.png)

Lines Count made Cloc by AlDanial 

https://github.com/AlDanial/cloc

```
      47 text files.
      41 unique files.
     136 files ignored.

github.com/AlDanial/cloc v 2.00  T=0.88 s (46.7 files/s, 5413.0 lines/s)
-------------------------------------------------------------------------------
Language                     files          blank        comment           code
-------------------------------------------------------------------------------
Java                            21            331            408           1814
XML                              8             31              0           1127
Bourne Shell                     2             56            232            209
DOS Batch                        2             42              4            138
Markdown                         1             36              0             88
Text                             1             13              0             64
SQL                              1             17              5             63
Gradle                           2             11             21             28
Properties                       2              0              1              8
TOML                             1              2              2              6
-------------------------------------------------------------------------------
SUM:                            41            539            673           3545
-------------------------------------------------------------------------------
```

codigo para WorkBench 

```
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
	
```

