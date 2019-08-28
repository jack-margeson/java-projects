/* Coordinates.java
Coordinate plane on JFrame using Swift, 3.7 Lab.
Jack Margeson, 08/28/2019 */

// Importations
import javax.swing.*; // GUI with Swing.
import java.awt.*; // Color.

public class Coordinates {
    // Declarations and init.
    private static JFrame GUI = new JFrame(); // GUI declaration from JFrame.
    private static Container pane = GUI.getContentPane(); // pane declaration from Container.

    // Main.
    public static void main(String[] args) {
        // Give properties to the frame.
        GUI.setTitle("Coordinates");
        GUI.setSize(500, 500);
        GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GUI.setVisible(true);
    }
}
