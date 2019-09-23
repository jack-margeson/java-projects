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
    private static JFrame frame = new JFrame(); // GUI declaration from JFrame. Coordinate plane.
    private static JFrame frame2 = new JFrame(); // GUI declaration from JFrame. Triangle calculation results.
    private static Container pane2 = frame2.getContentPane(); // GUI declaration from JPanel. Triangle calculation results.
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

    private static int x4 = -5;
    private static int y4 = -5;
    private static int x5 = -5;
    private static int y5 = -5;
    private static int x6 = -5;
    private static int y6 = -5;
    // These strings are set to null in order to prevent paintComponent from freaking out.
    private static String cstring1 = ""; // Used as a fixed coordinate string. (bottom output, graphically)
    private static String c2string1 = ""; // Used as a true coordinate string. (top output, graphically)
    private static String cstring2 = "";
    private static String c2string2 = "";
    private static String cstring3 = "";
    private static String c2string3 = "";

    private static String cstring4 = "";
    private static String c2string4 = "";
    private static String cstring5 = "";
    private static String c2string5 = "";
    private static String cstring6 = "";
    private static String c2string6 = "";

    private static int pcount = 0; // Point counter on click.

    // Main program.
    public static void main(String[] args) {
        // Set JFrame properties.
        frame.setSize(500, 500);
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
                        break;
                    case 3:
                        x4 = e.getX();
                        y4 = e.getY();
                        pcount++;
                        break;
                    case 4:
                        x5 = e.getX();
                        y5 = e.getY();
                        pcount++;
                        break;
                    case 5:
                        x6 = e.getX();
                        y6 = e.getY();
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

                cstring4 = "(" + (((pane.getWidth()/2) - x4)*-1) + ", " + ((pane.getHeight()/2) - y4) + ")";
                c2string4 = "(" + x4 + ", " + y4 + ")";
                cstring5 = "(" + (((pane.getWidth()/2) - x5)*-1) + ", " + ((pane.getHeight()/2) - y5) + ")";
                c2string5 = "(" + x5 + ", " + y5 + ")";
                cstring6 = "(" + (((pane.getWidth()/2) - x6)*-1) + ", " + ((pane.getHeight()/2) - y6) + ")";
                c2string6 = "(" + x6 + ", " + y6 + ")";
                pane.repaint();
            }
        });
    }

    private static void triangle() {
        // Declare triangle using point constructor.
        Triangle t1 = new Triangle(new Point(x1, y1), new Point(x2, y2), new Point(x3, y3), pane.getWidth(), pane.getHeight());
        Triangle t2 = new Triangle(new Point(x4, y4), new Point(x5, y5), new Point(x6, y6), pane.getWidth(), pane.getHeight());


        // Set JFrame properties.
        frame2.setSize(500, 500);
        // Create labels.
        JLabel lblt1 = new JLabel(t1.toHTML());
        JLabel lblt2 = new JLabel(t2.toHTML());
        // Add elements to pane.
        pane2.add(lblt1);
        pane2.add(lblt2);
        // Label properties.
        // Size.
        lblt1.setSize(200, 200);
        lblt2.setSize(200, 200);
        // Location.
        lblt1.setLocation(0, 0);
        lblt2.setLocation(0, 200);
        // Show results frame to user.
        frame2.setVisible(true);


        // Print triangle for debugging.
        System.out.println("Triangle #1" + "\n" +
                "Is it a triangle?: " + t1.isTri() + "\n" +
                "Kind of triangle: " + t1.kind() + "\n" +
                "Area: " + t1.area() + "\n" +
                "Perimeter: " + t1.perimeter() + "\n" +
                "Line segment lengths: " + t1.getDistances());
        // Print triangle for debugging.
        System.out.println("Triangle #2" + "\n" +
                "Is it a triangle?: " + t2.isTri() + "\n" +
                "Kind of triangle: " + t2.kind() + "\n" +
                "Area: " + t2.area() + "\n" +
                "Perimeter: " + t2.perimeter() + "\n" +
                "Line segment lengths: " + t2.getDistances());
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
            g.drawString(cstring4, x4 + 5, y4 - 5);
            g.drawString(cstring5, x5 + 5, y5 - 5);
            g.drawString(cstring6, x6 + 5, y6 - 5);
            // Draw label showing true coordinates.
            g.drawString(c2string1, x1 + 5, y1 - 25);
            g.drawString(c2string2, x2 + 5, y2 - 25);
            g.drawString(c2string3, x3 + 5, y3 - 25);
            g.drawString(c2string4, x4 + 5, y4 - 25);
            g.drawString(c2string5, x5 + 5, y5 - 25);
            g.drawString(c2string6, x6 + 5, y6 - 25);

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

            g2.drawLine(x4, y4, x4, y4);
            g2.drawLine(x5, y5, x5, y5);
            g2.drawLine(x6, y6, x6, y6);

            // If all three points have been drawn...
            if (pcount >= 3) {
                // Triangle line properties.
                g2.setColor(Color.blue);
                g2.setStroke(new BasicStroke(2));

                // Draw lines.
                g2.drawLine(x1, y1, x2, y2);
                g2.drawLine(x2, y2, x3, y3);
                g2.drawLine(x3, y3, x1, y1);
            }
            if (pcount >= 6) {
                // Triangle line properties.
                g2.setColor(Color.green);
                g2.setStroke(new BasicStroke(2));

                // Draw lines.
                g2.drawLine(x4, y4, x5, y5);
                g2.drawLine(x5, y5, x6, y6);
                g2.drawLine(x6, y6, x4, y4);
            }
        }
    }
}