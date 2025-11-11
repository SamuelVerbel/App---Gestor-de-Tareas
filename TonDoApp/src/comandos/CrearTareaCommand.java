package comandos;

import dominio.Tarea;
import java.util.List;

public class CrearTareaCommand implements Command {
    private final List<Tarea> lista;
    private final Tarea tarea;
    
    public CrearTareaCommand(List<Tarea> lista, Tarea tarea) {
        this.lista = lista;
        this.tarea = tarea;
    }
    
    @Override
    public void execute() {
        lista.add(tarea);
    }
    
    @Override
    public void undo() {
        lista.remove(tarea);
    }
}