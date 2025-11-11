package dominio;

public class TareaSimple extends Tarea {
    
    public TareaSimple(String titulo, String descripcion) {
        super(titulo, descripcion);
    }
    
    @Override
    public String getTipo() {
        return "Simple";
    }
    
    @Override
    public String getResumen() {
        return "[Simple] " + titulo;
    }
}