/* Coordinates.java
Coordinates for APCS 3.7 lab.
Jack Margeson, 09/09/2019 */

// Import statements.
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// Coordinates class.
public class Coordinates{
    // Declarations and init.
    private static JFrame frame = new JFrame(); // GUI declaration from JFrame.
    private static ColorPanel pane = new ColorPanel(new Color(255, 255, 255)); // Panel from ColorPanel.

    // Variables used for drawing labels.
    private static int x;
    private static int y;
    private static String cstring = "";

    public static void main(String[] args) {
        // Set JFrame properties.
        frame.setSize(500, 500);
        // Set ColorPanel properties.
        pane.setSize(500, 500);
        // Add ColorPanel to frame.
        frame.add(pane);

        // Show JFrame to the user.
        frame.setVisible(true);

        // Initialize MouseListener.
        pane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                x = e.getX();
                y = e.getY();
                cstring = "(" + (((pane.getWidth()/2) - e.getX())*-1) + ", " + ((pane.getHeight()/2) - e.getY()) + ")";
                pane.repaint();
            }
        });
    }

    // ColorPanel class
    static class ColorPanel extends JPanel {
        ColorPanel(Color color) {
            setBackground(color);
        }

        public void paintComponent(Graphics g) {
            // Create paint component.
            super.paintComponent(g);
            // Create Graphics2D component.
            Graphics2D g2 = (Graphics2D) g;

            // Axis properties.
            g2.setColor(Color.black);
            g2.setStroke(new BasicStroke(3));
            // Create axis lines.
            g2.drawLine(getWidth()/2, 0, getWidth()/2, getHeight());
            g2.drawLine(0, getHeight()/2, getWidth(), getHeight()/2);

            // Draw label showing origin.
            g.drawString("(0, 0)", getWidth()/2 + 10, (getHeight()/2) - 5);
            // Draw label showing coordinates.
            g.drawString(cstring, x + 5, y - 5);

            // Point properties.
            g2.setColor(Color.red);
            g2.setStroke(new BasicStroke(5));
            // Create point at...
            // ...the origin
            g2.drawLine(getWidth()/2, getHeight()/2, getWidth()/2, getHeight()/2);
            // ...the user's click.
            g2.drawLine(x, y, x, y);

        }
    }
}


