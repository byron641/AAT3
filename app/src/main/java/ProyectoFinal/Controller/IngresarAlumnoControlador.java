/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoFinal.Controller;

import ProyectoFinal.Model.IngresarAlumnoModel;
/**
 *
 * @author byron
 */
public class IngresarAlumnoControlador {

    private final IngresarAlumnoModel modelo;

    public IngresarAlumnoControlador() {
        modelo = new IngresarAlumnoModel();
    }

    public String insertarAlumno(String NombreAlumno, String ApellidoAlumno, int ClaveAlumno) {
        modelo.setNombreAlumno(NombreAlumno);
        modelo.setApellidoAlumno(ApellidoAlumno);
        modelo.setClaveAlumno(ClaveAlumno);
        return modelo.insertarAlumno(modelo);
    }
}
