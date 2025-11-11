package dominio;

import java.time.LocalDateTime;

public class TareaConDeadline extends Tarea {
    private LocalDateTime deadline;
    
    public TareaConDeadline(String titulo, String descripcion, LocalDateTime deadline) {
        super(titulo, descripcion);
        setDeadline(deadline);
    }
    
    @Override
    public String getTipo() {
        return "ConDeadline";
    }
    
    @Override
    public String getResumen() {
        return "[DL " + deadline + "] " + titulo;
    }
    
    public LocalDateTime getDeadline() { return deadline; }
    
    public void setDeadline(LocalDateTime deadline) {
        if (deadline != null && deadline.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("El deadline debe ser una fecha futura");
        }
        this.deadline = deadline;
    }
}