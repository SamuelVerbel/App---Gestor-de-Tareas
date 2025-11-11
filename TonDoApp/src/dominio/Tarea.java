package dominio;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
        
public abstract class Tarea implements Completable, Prioritizable, Serializable{
    protected String titulo;
    protected String descripcion;
    protected Prioridad prioridad = Prioridad.MEDIA;
    protected boolean completada = false;
    protected Set<String> etiquetas = new HashSet<>();
    
    public Tarea(String titulo, String descripcion){
        this.titulo = titulo;
        this.descripcion = descripcion;
    }
    
    public abstract String getTipo();
    public abstract String getResumen();
    
    @Override
    
    public void completar(){
        this.completada = true;
    }
    
    @Override
    public boolean estaCompletada(){
        return completada;
    }
    
    @Override
    public Prioridad getPrioridad(){
        return prioridad;
    }
    
    @Override
    public void setPrioridad(Prioridad prioridad){
        this.prioridad = prioridad;
    }
    
    //Getter and setters;
    public String getTitulo(){return titulo;}
    public void setTitulo(String titulo){this.titulo = titulo;}
    
    public String getDescripcion(){return descripcion;}
    public void setDescripcion(String descripcion){this.descripcion = descripcion;}
    
    public Set<String> getEtiquetas(){return etiquetas;}
    public void setEtiquetas(Set<String> etiquetas){this.etiquetas = etiquetas;}
    
    public void agregarEtiqueta(String etiqueta){
        this.etiquetas.add(etiqueta);
    }
    
    public void eliminarEtiqueta(String etiqueta){
        this.etiquetas.remove(etiqueta);
    }
    
    @Override
    public String toString(){
        return getResumen();
    } 
}
