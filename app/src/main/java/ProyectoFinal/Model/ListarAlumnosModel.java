package ProyectoFinal.Model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ListarAlumnosModel {
    private int IdAlumno;
    private String AlumnoNombre;
    private String AlumnoApellido;
    private int AlumnoClave;
    private Conexion conexion;

    public ListarAlumnosModel() {
        conexion = new Conexion();
    }

    public ListarAlumnosModel(int IdAlumno, String AlumnoNombre, String AlumnoApellido, int AlumnoClave) {
        this.IdAlumno = IdAlumno;
        this.AlumnoNombre = AlumnoNombre;
        this.AlumnoApellido = AlumnoApellido;
        this.AlumnoClave = AlumnoClave;
    }

    public int getIdAlumno() {
        return IdAlumno;
    }

    public void setIdAlumno(int IdAlumno) {
        this.IdAlumno = IdAlumno;
    }

    public String getAlumnoNombre() {
        return AlumnoNombre;
    }

    public void setAlumnoNombre(String AlumnoNombre) {
        this.AlumnoNombre = AlumnoNombre;
    }

    public String getAlumnoApellido() {
        return AlumnoApellido;
    }

    public void setAlumnoApellido(String AlumnoApellido) {
        this.AlumnoApellido = AlumnoApellido;
    }

    public int getAlumnoClave() {
        return AlumnoClave;
    }

    public void setAlumnoClave(int AlumnoClave) {
        this.AlumnoClave = AlumnoClave;
    }

    @Override
    public String toString() {
        return "ID: " + IdAlumno + ", Nombre: " + AlumnoNombre + ", Apellido: " + AlumnoApellido + ", Clave: " + AlumnoClave;
    }

    public List<ListarAlumnosModel> listarAlumnos() {
        List<ListarAlumnosModel> alumnos = new ArrayList<>();
        Connection cx = conexion.ConectarBD();
        if (cx != null) {
            try {
                String SPListarAlumnos = "{call ListarAlumnos()}";
                CallableStatement statement = cx.prepareCall(SPListarAlumnos);
                boolean hasResults = statement.execute();
                while (hasResults) {
                    try (ResultSet rs = statement.getResultSet()) {
                        while (rs.next()) {
                            int id = rs.getInt("IdAlumno");
                            String nombre = rs.getString("NombreAlumno");
                            String apellido = rs.getString("ApellidoAlumno");
                            int clave = rs.getInt("ClaveAlumno");
                            alumnos.add(new ListarAlumnosModel(id, nombre, apellido, clave));
                        }
                    }
                    hasResults = statement.getMoreResults();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                conexion.desconectar();
            }
        } else {
            System.out.println("No se pudo conectar a la base de datos");
        }
        return alumnos;
    }
}
