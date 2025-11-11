package servicio;

import comandos.Command;
import java.util.Stack;

public class GestorComandos {
    private final Stack<Command> undoStack = new Stack<>();
    private final Stack<Command> redoStack = new Stack<>();
    
    public void ejecutar(Command comando) {
        comando.execute();
        undoStack.push(comando);
        redoStack.clear(); // Limpiar redo stack cuando hay nueva acción
    }
    
    public void deshacer() {
        if (!undoStack.isEmpty()) {
            Command comando = undoStack.pop();
            comando.undo();
            redoStack.push(comando);
        }
    }
    
    public void rehacer() {
        if (!redoStack.isEmpty()) {
            Command comando = redoStack.pop();
            comando.execute();
            undoStack.push(comando);
        }
    }
    
    public boolean puedeDeshacer() {
        return !undoStack.isEmpty();
    }
    
    public boolean puedeRehacer() {
        return !redoStack.isEmpty();
    }
    
    public void limpiar() {
        undoStack.clear();
        redoStack.clear();
    }
}