/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoFinal.Controller;


import ProyectoFinal.Model.ModificarAlumnoModel;
import java.util.List;


/**
 *
 * @author byron
 */
public class ModificarAlumnoControlador {
    private final ModificarAlumnoModel modelo;

    public ModificarAlumnoControlador() {
        modelo = new ModificarAlumnoModel();
    }

    public List<ModificarAlumnoModel> leerAlumnos() {
        return modelo.leerAlumnos();
    }

    public ModificarAlumnoModel cargarDatosAlumno(int claveAlumno) {
        List<ModificarAlumnoModel> alumnos = modelo.leerAlumnos();
        for (ModificarAlumnoModel alumno : alumnos) {
            if (alumno.getClaveAlumno() == claveAlumno) {
                return alumno;
            }
        }
        return null;
    }

    public String actualizarAlumno(int claveAlumno, String nombreAlumno, String apellidoAlumno) {
        modelo.setClaveAlumno(claveAlumno);
        modelo.setNombreAlumno(nombreAlumno);
        modelo.setApellidoAlumno(apellidoAlumno);
        return modelo.actualizarAlumno(claveAlumno, nombreAlumno, apellidoAlumno); // Pasa los argumentos requeridos
    }
}