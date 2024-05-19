package ProyectoFinal.Controller;

import ProyectoFinal.Model.ListarAlumnosModel;
import java.util.List;

public class ListarAlumnosControlador {
    private ListarAlumnosModel modelo;

    public ListarAlumnosControlador() {
        modelo = new ListarAlumnosModel();
    }

    public List<ListarAlumnosModel> obtenerAlumnos() {
        return modelo.listarAlumnos();
    }
}
