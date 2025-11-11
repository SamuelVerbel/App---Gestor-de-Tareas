// comandos/EditarTareaCommand.java
package comandos;

import dominio.Tarea;
import java.util.List;

public class EditarTareaCommand implements Command {
    private final List<Tarea> lista;
    private final int indice;
    private final Tarea tareaOriginal;
    private final Tarea tareaEditada;
    
    public EditarTareaCommand(List<Tarea> lista, int indice, Tarea tareaEditada) {
        this.lista = lista;
        this.indice = indice;
        this.tareaOriginal = lista.get(indice);
        this.tareaEditada = tareaEditada;
    }
    
    @Override
    public void execute() {
        lista.set(indice, tareaEditada);
    }
    
    @Override
    public void undo() {
        lista.set(indice, tareaOriginal);
    }
}