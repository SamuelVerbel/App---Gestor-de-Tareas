package servicio;

import dominio.Tarea;
import dominio.TareaConDeadline;
import dominio.TareaRecurrente;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

public class SortByFecha implements SortingStrategy {
    @Override
    public List<Tarea> sort(List<Tarea> tareas) {
        tareas.sort(Comparator.comparing(tarea -> {
            if (tarea instanceof TareaConDeadline) {
                return ((TareaConDeadline) tarea).getDeadline();
            } else if (tarea instanceof TareaRecurrente) {
                return ((TareaRecurrente) tarea).getProxima().atStartOfDay();
            } else {
                return LocalDateTime.MAX; // Tareas sin fecha al final
            }
        }));
        return tareas;
    }
}