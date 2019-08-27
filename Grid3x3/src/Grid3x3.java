/* Grid3x3.java
A 3x3 GUI grid creator written in Java, chapter 2.7.
Jack Margeson, 08/21/2019 */

// Importations
import javax.swing.*;
import java.awt.*;
// import java.util.Scanner;

// Grid3x3 class.
public class Grid3x3 {
    // Declarations and init.
    private static JFrame GUI = new JFrame(); // GUI declaration from JFrame.
    private static Container pane = GUI.getContentPane(); // pane declaration from Container.
    // private static Scanner scanner = new Scanner(System.in); // Scanner object for user input from Scanner.

    public static void main(String[] args) {
        // Declaration and init.
        String ans; // Used for the do while loop.

        do {
            // Give properties to the frame.
            GUI.setTitle("3x3 Grid");
            GUI.setSize(300, 300);
            GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            pane.removeAll(); // Removes all panes.

            // Grabs user input for width and height using option panes.
            JOptionPane opane = new JOptionPane(JOptionPane.QUESTION_MESSAGE, JOptionPane.QUESTION_MESSAGE);
            opane.setVisible(true);
            int w = Integer.parseInt(JOptionPane.showInputDialog("Enter width:", 3));
            int h = Integer.parseInt(JOptionPane.showInputDialog("Enter hours:", 3));

            /* System.out.println("Enter width: ");
            int w = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter height: ");
            int h = Integer.parseInt(scanner.nextLine()); */
            // Set the grid size to the user defined width and height.
            pane.setLayout(new GridLayout(h, w));

            // Loops through the amount of panels that needs to be created.
            // Panel # is calculated through user inputted wxh.
            for (int i = 0; i < (w * h); i++) {
                createPanel();
            }

            // Make the GUI visible to the user.
            GUI.setVisible(true);

            ans = JOptionPane.showInputDialog("Run again? (y/n):", "y");
        } while (ans.equals("y") || ans.equals("Y"));
        GUI.setVisible(false);
        System.exit(0);
    }

    // createPanel
    // Creates a panel and adds it to the GUI.
    private static void createPanel() {
        // Declare random ints. for panel color.
        int r1 = (int)(255 * Math.random());
        int r2 = (int)(255 * Math.random());
        int r3 = (int)(255 * Math.random());
        // Init. new JPanel.
        JPanel panel = new JPanel();
        // Sets background color for the panel.
        panel.setBackground(new Color(r1,r2,r3));
        // Adds panel to GUI.
        pane.add(panel);
    }
}
