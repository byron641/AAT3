/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoFinal.Model;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;
/**
 *
 * @author byron
 */
public class IngresarAlumnoModel {
      private String NombreAlumno;
    private String ApellidoAlumno;
    private int ClaveAlumno;

    public String getNombreAlumno() {
        return NombreAlumno;
    }

    public void setNombreAlumno(String NombreAlumno) {
        this.NombreAlumno = NombreAlumno;
    }

    public String getApellidoAlumno() {
        return ApellidoAlumno;
    }

    public void setApellidoAlumno(String ApellidoAlumno) {
        this.ApellidoAlumno = ApellidoAlumno;
    }

    public int getClaveAlumno() {
        return ClaveAlumno;
    }

    public void setClaveAlumno(int ClaveAlumno) {
        this.ClaveAlumno = ClaveAlumno;
    }

    private final Conexion conexion;

    public IngresarAlumnoModel() {
        conexion = new Conexion();
    }

    public String insertarAlumno(IngresarAlumnoModel alumno) {
        Connection cx = conexion.ConectarBD();
        if (cx != null) {
            try {
                String SPInsertarAlumno = "{call InsertarAlumno(?, ?, ?)}";
                CallableStatement statement = cx.prepareCall(SPInsertarAlumno);
                statement.setString(1, alumno.getNombreAlumno());
                statement.setString(2, alumno.getApellidoAlumno());
                statement.setInt(3, alumno.getClaveAlumno());
                statement.execute();
                return "El alumno se insertó con éxito";
            } catch (SQLException ex) {
                return ex.getMessage();
            } finally {
                conexion.desconectar();
            }
        } else {
            return "No se pudo conectar a la base de datos";
        }
    }
}
