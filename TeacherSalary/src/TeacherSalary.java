/* TeacherSalary.java
Teacher salary program 4.1 lab written in Java.
Jack Margeson, 09/24/2019 */

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Imports.
public class TeacherSalary {
    // Declarations and init.
    private static JFrame GUI = new JFrame(); // New JFrame from Swing.
    private static JTable table; // Create table object.
    private static Container pane = GUI.getContentPane(); // pane declaration from Container.
    private static JOptionPane optionPane = new JOptionPane(JOptionPane.QUESTION_MESSAGE, JOptionPane.QUESTION_MESSAGE); // JOptionPane, used for getting user input through the GUI.
    private static String ans; // used for answering questions.
    // Teacher variables.
    private static Teacher t1; // Teacher.
    private static double salary = 0;
    private static int years = 0;
    private static String degree = "";

    // Main program.
    public static void main(String[] args) {
        // Give properties to the GUI.
        GUI.setTitle("Teacher Salary");
        GUI.setSize(580, 355);
        GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Give properties to the pane.
        pane.setBackground(new Color(163, 255, 188));
        pane.setLayout(null);


        // Get user input through optionPane.
        optionPane.setVisible(true);
        String ans = JOptionPane.showInputDialog("Input teacher or load from file? (input/file): ", "file");
        if (ans.equals("input")) {
            teacherFromInput();
        } else {
            teacherFromFile();
        }

        // Get table.
        String[] tableTitles = new String[]{"Years", "Bachelors", "Masters", "PhD"};
        table = new JTable(t1.getSalaryTable(), tableTitles);
        // JTable properties.
        table.setLocation(0,0);
        table.setSize(400,335);
        // Add table to pane2.
        pane.add(table);

        // Set JLabel.
        JLabel l1 = new JLabel(t1.toHTML());
        // JLabel properties.
        l1.setLocation(420, 75);
        l1.setSize(200, 200);
        // Add label to pane.
        pane.add(l1);

        // Make the GUI visible to the user.
        GUI.setVisible(true);
    }

    // User input for creating a teacher.
    private static void teacherFromInput() {
        optionPane.setVisible(true);
        salary = Double.parseDouble(JOptionPane.showInputDialog("Input teacher's base salary: ", "40000"));
        years = Integer.parseInt(JOptionPane.showInputDialog("Input teacher's years worked: ", "3"));
        degree = JOptionPane.showInputDialog("Input teacher's degree (bachelors/masters/phd): ", "masters");

        t1 = new Teacher(salary, years, degree);
    }

    // File input for creating a teacher.
    private static void teacherFromFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("teacher.txt"));
            String input;
            int i = 1;
            while ((input = br.readLine()) != null) {
                switch (i) {
                    case 1:
                        salary = Double.parseDouble(input);
                        i++;
                        break;
                    case 2:
                        years = Integer.parseInt(input);
                        i++;
                        break;
                    case 3:
                        degree = input;
                        break;
                }
            }
        } catch(IOException err) {
            System.err.println("IO error.");
        }
        t1 = new Teacher(salary, years, degree);
    }
}
