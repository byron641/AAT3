package ProyectoFinal.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel {
    private final Conexion conexion;
    
    public LoginModel() {
        conexion = new Conexion();
    }

    public class Usuario {
        private String nombre;
        private int rol;
        private int tipoUsuario;

        public Usuario() {
        }

        public Usuario(String nombre, int rol) {
            this.nombre = nombre;
            this.rol = rol;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getRol() {
            return rol;
        }

        public void setRol(int rol) {
            this.rol = rol;
        }

        public int getTipoUsuario() {
            return tipoUsuario;
        }

        public void setTipoUsuario(int tipoUsuario) {
            this.tipoUsuario = tipoUsuario;
        }
    }

    public Usuario verificarCredenciales(String nombreUsuario, String contrasena) throws SQLException {
        Connection cx = conexion.conectar();
        if (cx != null) {
            try {
                String SPVerificarCredenciales = "{call SPVerificarCredenciales(?, ?)}";
                PreparedStatement statement = cx.prepareStatement(SPVerificarCredenciales);
                statement.setString(1, nombreUsuario);
                statement.setString(2, contrasena);
                try (ResultSet rs = statement.executeQuery()) {
                    if (rs.next()) {
                        Usuario usuario = new Usuario();
                        usuario.setNombre(rs.getString("NombreLogin"));
                        usuario.setTipoUsuario(rs.getInt("tipoUsuario"));
                        return usuario;
                    } else {
                        return null;
                    }
                }
            } catch (SQLException ex) {
                throw ex;
            } finally {
                conexion.desconectar();
            }
        } else {
            System.out.println("No se pudo conectar a la base de datos");
            return null;
        }
    }
}
