package servicio;

import dominio.Tarea;
import java.util.Comparator;
import java.util.List;

public class SortByPrioridad implements SortingStrategy {
    @Override
    public List<Tarea> sort(List<Tarea> tareas) {
        tareas.sort(Comparator.comparing(Tarea::getPrioridad).reversed());
        return tareas;
    }
}