/* Coordinates.java
Coordinate plane on JFrame using Swift, 3.7 Lab.
Jack Margeson, 08/28/2019 */

// Importations
import javax.swing.*; // GUI with Swing.
import java.awt.*; // Color.

public class Coordinates {
    // Declarations and init.
    private static JFrame frame = new JFrame(); // GUI declaration from JFrame.
    private static Container pane = frame.getContentPane(); // pane declaration from Container.

    // Main.
    public static void main(String[] args) {
        // Give properties to the frame.
        frame.setTitle("Coordinates");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initializes panel.
        initPanel();

        // Make GUI visible to the user.
        frame.setVisible(true);
    }

    private static void initPanel() {
        // Make panel that takes up the entire width and height of the pane.
        JPanel panel = new JPanel();
        panel.setSize(500, 500);
        panel.setBackground(new Color(196, 255, 199));
        // Set pane layout.
        pane.setLayout(new GridLayout(1, 1));
        // Add panel to the pane.
        pane.add(panel);
    }
}
