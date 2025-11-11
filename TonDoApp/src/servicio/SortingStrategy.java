package servicio;

import dominio.Tarea;
import java.util.List;

public interface SortingStrategy {
    List<Tarea> sort(List<Tarea> tareas);
}