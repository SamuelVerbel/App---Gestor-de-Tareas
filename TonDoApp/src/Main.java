import javax.swing.JOptionPane;
import persistencia.TaskRepositoryBin;
import servicio.TaskService;
import ui.MainFrame;
import javax.swing.SwingUtilities;

// Main.java
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                TaskRepositoryBin repository = new TaskRepositoryBin();
                TaskService taskService = new TaskService(repository);
                
                MainFrame mainFrame = new MainFrame(); // Sin parámetros
                mainFrame.setTaskService(taskService); // Usar el método setter
                mainFrame.setVisible(true);
                
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, 
                    "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}