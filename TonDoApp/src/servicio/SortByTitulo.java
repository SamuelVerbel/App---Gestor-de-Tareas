package servicio;

import dominio.Tarea;
import java.util.Comparator;
import java.util.List;

public class SortByTitulo implements SortingStrategy {
    @Override
    public List<Tarea> sort(List<Tarea> tareas) {
        tareas.sort(Comparator.comparing(Tarea::getTitulo));
        return tareas;
    }
}