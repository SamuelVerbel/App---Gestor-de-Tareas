package dominio;

import java.time.LocalDate;
import java.time.Period;

public class TareaRecurrente extends Tarea {
    private Period frecuencia;
    private LocalDate proxima;
    
    public TareaRecurrente(String titulo, String descripcion, Period frecuencia, LocalDate proxima) {
        super(titulo, descripcion);
        setFrecuencia(frecuencia);
        this.proxima = proxima;
    }
    
    @Override
    public String getTipo() {
        return "Recurrente";
    }
    
    @Override
    public String getResumen() {
        return "[Recurr. cada " + frecuencia + "] " + titulo;
    }
    
    @Override
    public void completar() {
        super.completar();
        reprogramarProxima();
    }
    
    private void reprogramarProxima() {
        if (frecuencia != null) {
            this.proxima = LocalDate.now().plus(frecuencia);
            this.completada = false; // Se marca como pendiente para el próximo ciclo
        }
    }
    
    public Period getFrecuencia() { return frecuencia; }
    
    public void setFrecuencia(Period frecuencia) {
        if (frecuencia != null && (frecuencia.isNegative() || frecuencia.isZero())) {
            throw new IllegalArgumentException("La frecuencia debe ser positiva");
        }
        this.frecuencia = frecuencia;
    }
    
    public LocalDate getProxima() { return proxima; }
    public void setProxima(LocalDate proxima) { this.proxima = proxima; }
}