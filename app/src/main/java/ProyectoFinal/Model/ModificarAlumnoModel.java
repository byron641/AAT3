/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoFinal.Model;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author byron
 */
public class ModificarAlumnoModel {
    private String nombreAlumno;
    private String apellidoAlumno;
    private int claveAlumno;
    private final Conexion conexion;

    public ModificarAlumnoModel() {
        conexion = new Conexion();
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getApellidoAlumno() {
        return apellidoAlumno;
    }

    public void setApellidoAlumno(String apellidoAlumno) {
        this.apellidoAlumno = apellidoAlumno;
    }

    public int getClaveAlumno() {
        return claveAlumno;
    }

    public void setClaveAlumno(int claveAlumno) {
        this.claveAlumno = claveAlumno;
    }

public List<ModificarAlumnoModel> leerAlumnos() {
        Connection cx = conexion.ConectarBD();
        List<ModificarAlumnoModel> alumnos = new ArrayList<>();
        if (cx != null) {
            try {
                String SPLeerAlumno = "{call LeerAlumno()}";
                CallableStatement statement = cx.prepareCall(SPLeerAlumno);

            } catch (SQLException ex) {
                // Manejo de errores
                System.err.println("Error al leer alumnos: " + ex.getMessage());
            } finally {
                conexion.desconectar();
            }
        }
        return alumnos;
    }

    public String actualizarAlumno(ModificarAlumnoModel alumno) {
        Connection cx = conexion.ConectarBD();
        if (cx != null) {
            try {
                String SPActualizarAlumno = "{call ActualizarAlumno(?, ?, ?)}";
                CallableStatement statement = cx.prepareCall(SPActualizarAlumno);
                statement.setInt(1, alumno.getClaveAlumno());
                statement.setString(2, alumno.getNombreAlumno());
                statement.setString(3, alumno.getApellidoAlumno());
                statement.execute();
                return "El alumno se actualizó con éxito";
            } catch (SQLException ex) {
                return "Error al actualizar alumno: " + ex.getMessage();
            } finally {
                conexion.desconectar();
            }
        } else {
            return "No se pudo conectar a la base de datos";
        }
    }
   
    
}
