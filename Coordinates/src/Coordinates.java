/* Coordinates.java
Coordinate plane on JFrame using Swift, 3.7 Lab.
Jack Margeson, 08/28/2019 */

// Importations
import javax.swing.*; // GUI with Swing.
import java.awt.*; // Color.
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Coordinates {
    // Declarations and init.
    private static JFrame frame = new JFrame(); // GUI declaration from JFrame.
    private static Container pane = frame.getContentPane(); // pane declaration from Container.
    private static JLabel label = new JLabel();

    // Main.
    public static void main(String[] args) {
        // Initializes JFrame.
        initJFrame();
        // Initialize MouseListener.
        pane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                setLabel(e.getX(), e.getY());
            }
        });
    }

    private static void initJFrame() {
        // Give properties to the frame.
        frame.setTitle("Coordinates");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pane.removeAll(); // Removes all objects from the pane.

        // Make panel that takes up the entire width and height of the pane.
        JPanel panel = new JPanel();
        panel.setSize(500, 500);
        panel.setBackground(new Color(196, 255, 199));
        // Set pane layout.
        pane.setLayout(new GridLayout(1, 1));// Set label position.
        // Add panel to the pane.
        pane.add(panel);

        // Make GUI visible to the user.
        frame.setVisible(true);
    }

    private static void setLabel(int x, int y) {
        System.out.println(x + ", " + y);
        // Set label text.
        label.setText(x + ", " + y);
        // Add label.
        pane.add(label);
        // Set label properties.
        label.setLocation(x, y);
        label.setSize(50, 50);
        label.setOpaque(true);
        // Refresh GUI.
        frame.setVisible(true);
    }
}
