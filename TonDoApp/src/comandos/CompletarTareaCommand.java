package comandos;

import dominio.Tarea;
import java.util.List;

public class CompletarTareaCommand implements Command {
    private final List<Tarea> lista;
    private final int indice;
    private final boolean estadoAnterior;
    private final boolean nuevoEstado;
    
    public CompletarTareaCommand(List<Tarea> lista, int indice, boolean completar) {
        this.lista = lista;
        this.indice = indice;
        this.estadoAnterior = lista.get(indice).estaCompletada();
        this.nuevoEstado = completar;
    }
    
    @Override
    public void execute() {
        Tarea tarea = lista.get(indice);
        if (nuevoEstado) {
            tarea.completar();
        } else {
            // Para descompletar necesitamos un método en la interfaz
            // Por ahora lo dejamos así
        }
    }
    
    @Override
    public void undo() {
        Tarea tarea = lista.get(indice);
        if (estadoAnterior) {
            tarea.completar();
        } else {
            // Para descompletar
        }
    }
}