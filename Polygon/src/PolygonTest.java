/* PolygonTest.java
A polygon tester class for Polygon project.
ColorPanel and other classes re-purposed from Triangle project (use work done so far!)
Jack Margeson, 10/22/2019 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// Polygon tester class.
public class PolygonTest {
    // Declarations.
    // GUI declarations.
    private static JFrame GUI = new JFrame(); // Coordinate plane.
    private static JFrame RESULTS = new JFrame(); // Results GUI.
    private static Container pane2 = RESULTS.getContentPane();
    private static JLabel results;
    private static ColorPanel panel = new ColorPanel(new Color(255, 255, 255)); // New panel from ColorPanel.
    private static Point[] points;
    private static int u;
    private static int pd = 0;

    // Main program.
    public static void main(String[] args) {
        // Get the numbers of sides the user would like to draw.
        u = Integer.parseInt(JOptionPane.showInputDialog("How many sides would you like to draw?", "4"));

        // Mouse event listener.
        // Allows the user to draw on the grid up to the amount of sides that they've entered.
        // Init. array of points for the color panel.
        points = new Point[u];
        for (int i = 0; i < u; i++) {
            points[i] = new Point(20000, 2000);
        }
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (pd < u) {
                   points[pd] = new Point(((panel.getWidth()/2) - e.getX()) * -1, (panel.getHeight()/2) - e.getY());
                   panel.repaint();
                   pd++;
                   if (pd == u) {
                       createPolygon(points);
                   }
                }
            }
        });

        // Set ColorPanel and GUI properties.
        GUI.setSize(600, 600);
        panel.setSize(600, 600);

        // Add ColorPanel to GUI.
        GUI.add(panel);
        // Display GUI.
        GUI.setVisible(true);
    }

    // createPolygon(Point[] p)
    // Creates a polygon given points.
    public static void createPolygon(Point[] points) {
        // Create line segment array.
        Lineseg[] linesegs = new Lineseg[points.length];
        for (int i = 0; i < points.length; i++) {
            if ((i + 1) < points.length) {
                linesegs[i] = new Lineseg(points[i], points[i + 1]);
            } else {
                // Last lineseg.
                linesegs[i] = new Lineseg(points[i], points[0]);
            }
        }
        // Create polygon and send to polygonInfo(Polygon p).
        polygonInfo(new Polygon(linesegs));
    }

    public static void polygonInfo(Polygon p1) {
        System.out.println(p1);
        // Set JLabel.
        results = new JLabel(p1.toHTML());

        // JPanel properties.
        RESULTS.setSize(200,200);
        // JLabel properties.
        results.setSize(200, 200);
        results.setLocation(0, 0);

        // Add and create GUI.
        RESULTS.add(results);
        RESULTS.setVisible(true);
    }

    // ColorPanel class.
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
            for (int i = 0; i < getWidth(); i += 10) {
                g2.drawLine(i, 0, i, getHeight());
                g2.drawLine(0, i, getWidth(), i);
            }

            // Axis properties.
            g2.setColor(Color.black);
            g2.setStroke(new BasicStroke(3));
            // Create axis lines.
            g2.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());
            g2.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);

            // Text properties.
            g.setColor(Color.black);
            // Draw label showing origin.
            g.drawString("(0, 0)", getWidth() / 2 + 10, (getHeight() / 2) - 5);

            // Point properties.
            g2.setColor(Color.red);
            g2.setStroke(new BasicStroke(5));
            // Create point at...
            // ...the origin
            g2.drawLine(getWidth() / 2, getHeight() / 2, getWidth() / 2, getHeight() / 2);
            // ... all of the users points.
            for(Point point:points) {
                int x = (int) ((getWidth()/2) + point.getMy_x());
                int y = (int) ((getHeight()/2) - point.getMy_y());
                g2.drawLine(x, y, x, y);
            }

            // Draw the connecting lines if all of the points have been drawn.
            if (u == pd) {
                // Set the color and stroke.
                g2.setColor(Color.blue);
                g2.setStroke(new BasicStroke(2));

                // Draw lines.
                for(int i = 0; i < u; i++) {
                    int x = (int) ((getWidth()/2) + points[i].getMy_x());
                    int y = (int) ((getHeight()/2) - points[i].getMy_y());
                    if ((i + 1) < u) {
                        int x2 = (int) ((getWidth() / 2) + points[i + 1].getMy_x());
                        int y2 = (int) ((getHeight() / 2) - points[i + 1].getMy_y());
                        g2.drawLine(x, y, x2, y2);
                    } else {
                        int x2 = (int) ((getWidth() / 2) + points[0].getMy_x());
                        int y2 = (int) ((getHeight() / 2) - points[0].getMy_y());
                        g2.drawLine(x, y, x2, y2);
                    }
                }
            }
        }
    }
}


