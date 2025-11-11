package dominio;

public interface Prioritizable {
    enum Prioridad { BAJA, MEDIA, ALTA, CRITICA }

    Prioridad getPrioridad();
    void setPrioridad(Prioridad p);
}
