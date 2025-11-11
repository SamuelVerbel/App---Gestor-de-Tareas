package comandos;

import dominio.Tarea;
import java.util.List;

public class EliminarTareaCommand implements Command {
    private final List<Tarea> lista;
    private final Tarea tarea;
    private final int indice;
    
    public EliminarTareaCommand(List<Tarea> lista, int indice) {
        this.lista = lista;
        this.indice = indice;
        this.tarea = lista.get(indice);
    }
    
    @Override
    public void execute() {
        lista.remove(indice);
    }
    
    @Override
    public void undo() {
        lista.add(indice, tarea);
    }
}