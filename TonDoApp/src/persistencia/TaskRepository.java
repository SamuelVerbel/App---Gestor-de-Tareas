package persistencia;

import dominio.Tarea;
import java.util.List;

public interface TaskRepository {
    void saveAll(List<Tarea> tareas);
    List<Tarea> loadAll();
    String getFilePath();
}