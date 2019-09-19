/* TriangleTest.java
Coordinates for APCS 3.7 lab.
Jack Margeson, 09/09/2019 */

// A lot of this code is scraped from the Coordinate (3.7) Lab.
// https://github.com/jack-margeson/java-projects/blob/master/Coordinates/src/Coordinates.java

// Import statements.
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// Coordinates class.
public class TriangleTest{
    // Declarations and init.
    // Classes.
    private static JFrame frame = new JFrame(); // GUI declaration from JFrame.
    private static ColorPanel pane = new ColorPanel(new Color(255, 255, 255)); // Panel from ColorPanel.

    // Variables used for drawing labels.
    /* These variables are set to -5 in order to have them not be displayed
    when paintComponent is called on start up. */
    private static int x1 = -5;
    private static int y1 = -5;
    private static int x2 = -5;
    private static int y2 = -5;
    private static int x3 = -5;
    private static int y3 = -5;
    // These strings are set to null in order to prevent paintComponent from freaking out.
    private static String cstring1 = ""; // Used as a fixed coordinate string. (bottom output, graphically)
    private static String c2string1 = ""; // Used as a true coordinate string. (top output, graphically)
    private static String cstring2 = "";
    private static String c2string2 = "";
    private static String cstring3 = "";
    private static String c2string3 = "";

    private static int pcount = 0; // Point counter on click.

    // Main program.
    public static void main(String[] args) {
        // Set JFrame properties.
        frame.setSize(500, 500);
        // Set ColorPanel properties.
        // Add ColorPanel to frame.
        frame.add(pane);

        // Show JFrame to the user.
        frame.setVisible(true);

        // Initialize MouseListener.
        pane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                switch (pcount) {
                    case 0:
                        x1 = e.getX();
                        y1 = e.getY();
                        pcount++;
                        break;
                    case 1:
                        x2 = e.getX();
                        y2 = e.getY();
                        pcount++;
                        break;
                    case 2:
                        x3 = e.getX();
                        y3 = e.getY();
                        pcount++;
                        triangle();
                        break;
                }
                // Adjusted coordinate string for screen output.
                cstring1 = "(" + (((pane.getWidth()/2) - x1)*-1) + ", " + ((pane.getHeight()/2) - y1) + ")";
                c2string1 = "(" + x1 + ", " + y1 + ")";
                cstring2 = "(" + (((pane.getWidth()/2) - x2)*-1) + ", " + ((pane.getHeight()/2) - y2) + ")";
                c2string2 = "(" + x2 + ", " + y2 + ")";
                cstring3 = "(" + (((pane.getWidth()/2) - x3)*-1) + ", " + ((pane.getHeight()/2) - y3) + ")";
                c2string3 = "(" + x3 + ", " + y3 + ")";
                pane.repaint();
            }
        });
    }

    private static void triangle() {
        // Declare triangle.
        // Triangle calculations.
    }

    // ColorPanel class
    static class ColorPanel extends JPanel {
        // ColorPanel constructors.
        // Default constructor.
        ColorPanel() {
            setBackground(Color.white);
        }
        // Fill constructor.
        ColorPanel(Color color) {
            setBackground(color);
        }

        public void paintComponent(Graphics g) {
            // Create paint component.
            super.paintComponent(g);
            // Create Graphics2D component.
            Graphics2D g2 = (Graphics2D) g;

            // Drawing grid first, then axis to overlay.

            // Grid properties.
            g2.setColor(new Color(206, 206, 206));
            g2.setStroke(new BasicStroke(1));
            // Create grid lines.
            for (int i = 0; i < getWidth(); i+=10) {
                g2.drawLine(i, 0, i, getHeight());
                g2.drawLine(0, i, getWidth(), i);
            }

            // Axis properties.
            g2.setColor(Color.black);
            g2.setStroke(new BasicStroke(3));
            // Create axis lines.
            g2.drawLine(getWidth()/2, 0, getWidth()/2, getHeight());
            g2.drawLine(0, getHeight()/2, getWidth(), getHeight()/2);

            // Text properties.
            g.setColor(Color.black);
            // Draw label showing origin.
            g.drawString("(0, 0)", getWidth()/2 + 10, (getHeight()/2) - 5);

            // Point labeling.
            // Draw label showing coordinates.
            g.drawString(cstring1, x1 + 5, y1 - 5);
            g.drawString(cstring2, x2 + 5, y2 - 5);
            g.drawString(cstring3, x3 + 5, y3 - 5);
            // Draw label showing true coordinates.
            g.drawString(c2string1, x1 + 5, y1 - 25);
            g.drawString(c2string2, x2 + 5, y2 - 25);
            g.drawString(c2string3, x3 + 5, y3 - 25);

            // Point properties.
            g2.setColor(Color.red);
            g2.setStroke(new BasicStroke(5));
            // Create point at...
            // ...the origin
            g2.drawLine(getWidth()/2, getHeight()/2, getWidth()/2, getHeight()/2);
            // ...the user's click.
            g2.drawLine(x1, y1, x1, y1);
            g2.drawLine(x2, y2, x2, y2);
            g2.drawLine(x3, y3, x3, y3);

            // If all three points have been drawn...
            if (pcount == 3) {
                // Triangle line properties.
                g2.setColor(Color.blue);
                g2.setStroke(new BasicStroke(2));

                // Draw lines.
                g2.drawLine(x1, y1, x2, y2);
                g2.drawLine(x2, y2, x3, y3);
                g2.drawLine(x3, y3, x1, y1);
            }
        }
    }
}