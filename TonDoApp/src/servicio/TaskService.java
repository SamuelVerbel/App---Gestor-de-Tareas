package servicio;

import dominio.Tarea;
import persistencia.TaskRepository;
import comandos.Command;
import comandos.CrearTareaCommand;
import comandos.EliminarTareaCommand;
import comandos.EditarTareaCommand;
import comandos.CompletarTareaCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TaskService {
    private final List<Tarea> tareas;
    private final TaskRepository repository;
    private final GestorComandos gestorComandos;
    private SortingStrategy estrategiaOrdenamiento;
    
    public TaskService(TaskRepository repository) {
        this.repository = repository;
        this.tareas = new ArrayList<>();
        this.gestorComandos = new GestorComandos();
        this.estrategiaOrdenamiento = new SortByPrioridad(); // Estrategia por defecto
        
        cargarTareas();
    }
    
    public void agregarTarea(Tarea tarea) {
        Command comando = new CrearTareaCommand(tareas, tarea);
        gestorComandos.ejecutar(comando);
        guardarTareas();
    }
    
    public void eliminarTarea(int indice) {
        if (indice >= 0 && indice < tareas.size()) {
            Command comando = new EliminarTareaCommand(tareas, indice);
            gestorComandos.ejecutar(comando);
            guardarTareas();
        }
    }
    
    public void editarTarea(int indice, Tarea tareaEditada) {
        if (indice >= 0 && indice < tareas.size()) {
            Command comando = new EditarTareaCommand(tareas, indice, tareaEditada);
            gestorComandos.ejecutar(comando);
            guardarTareas();
        }
    }
    
    public void completarTarea(int indice, boolean completar) {
        if (indice >= 0 && indice < tareas.size()) {
            Command comando = new CompletarTareaCommand(tareas, indice, completar);
            gestorComandos.ejecutar(comando);
            guardarTareas();
        }
    }
    
    public List<Tarea> getTareas() {
        return new ArrayList<>(tareas);
    }
    
    public List<Tarea> getTareasOrdenadas() {
        return estrategiaOrdenamiento.sort(new ArrayList<>(tareas));
    }
    
    public List<Tarea> filtrarTareas(Predicate<Tarea> filtro) {
        return tareas.stream()
                .filter(filtro)
                .collect(Collectors.toList());
    }
    
    public void setEstrategiaOrdenamiento(SortingStrategy estrategia) {
        this.estrategiaOrdenamiento = estrategia;
    }
    
    public void deshacer() {
        gestorComandos.deshacer();
        guardarTareas();
    }
    
    public void rehacer() {
        gestorComandos.rehacer();
        guardarTareas();
    }
    
    public boolean puedeDeshacer() {
        return gestorComandos.puedeDeshacer();
    }
    
    public boolean puedeRehacer() {
        return gestorComandos.puedeRehacer();
    }
    
    private void cargarTareas() {
        tareas.clear();
        tareas.addAll(repository.loadAll());
    }
    
    private void guardarTareas() {
        repository.saveAll(tareas);
    }
}