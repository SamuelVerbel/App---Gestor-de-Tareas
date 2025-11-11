// persistencia/TaskRepositoryBin.java
package persistencia;

import dominio.Tarea;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskRepositoryBin implements TaskRepository {
    private static final String FILE_NAME = "tareas.dat";
    private final File dataFile;
    
    public TaskRepositoryBin() {
        this.dataFile = new File(FILE_NAME);
    }
    
    @Override
    public void saveAll(List<Tarea> tareas) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dataFile))) {
            oos.writeObject(tareas);
        } catch (IOException e) {
            throw new RuntimeException("Error guardando tareas: " + e.getMessage(), e);
        }
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public List<Tarea> loadAll() {
        if (!dataFile.exists()) {
            return new ArrayList<>();
        }
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dataFile))) {
            return (List<Tarea>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Error cargando tareas: " + e.getMessage(), e);
        }
    }
    
    @Override
    public String getFilePath() {
        return dataFile.getAbsolutePath();
    }
}