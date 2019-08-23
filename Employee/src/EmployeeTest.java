/* EmployeeTest.java
An employee class tester in Java.
Jack Margeson, 08/23/2019 */

// Imports.
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class EmployeeTest {
    // Declarations and init.
    private static JFrame GUI = new JFrame(); // GUI declaration from JFrame.
    private static Container pane = GUI.getContentPane(); // pane declaration from Container.
    private static Scanner scanner = new Scanner(System.in); // Scanner obj. from Scanner.

    // Main.
    public static void main(String[] args) {
        // Give properties to the frame.
        GUI.setTitle("Employee");
        GUI.setSize(900, 190);
        GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pane.setBackground(new Color(163, 255, 188));
        pane.setLayout(null);

        // Default constructor test.
        // Create employee.
        Employee e1 = new Employee();
        // Create label.
        JLabel lblDefaultConstructor = new JLabel("<html>Default constructor<br/>" +
                "----------<br/><html>"
                + e1.getHTML());

        // Fill constructor test.
        // Create employee.
        Employee e2 = new Employee("Jack", "Margeson", "Dutch", 8, 12.00, 605555, 2);
        // Create label.
        JLabel lblFillConstructor = new JLabel("<html>Fill constructor<br/>" +
                "----------<br/><html>"
                + e2.getHTML());

        // Copy constructor test.
        // Create employee--Employee e2 -> employee e3.
        Employee e3 = new Employee(e2);
        // Create label.
        JLabel lblCopyConstructor = new JLabel("<html>Copy constructor<br/>" +
                "----------<br/><html>"
                + e3.getHTML());

        // User inputted fill constructor test.
        // Create input panel and grab user input.
        JOptionPane opane = new JOptionPane(JOptionPane.QUESTION_MESSAGE, JOptionPane.QUESTION_MESSAGE);
        opane.setVisible(true);
        String first = JOptionPane.showInputDialog("Enter first name:", "");
        String last = JOptionPane.showInputDialog("Enter last name:", "");
        String nickname = JOptionPane.showInputDialog("Enter nickname:", "");
        int hours = Integer.parseInt(JOptionPane.showInputDialog("Enter hours:", 0));
        double salary = Double.parseDouble(JOptionPane.showInputDialog("Enter salary:", 0));
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID:", 0));
        int years = Integer.parseInt(JOptionPane.showInputDialog("Enter years worked:", 0));
        // Create employee.
        Employee e4 = new Employee(first, last, nickname, hours, salary, id, years);
        // Create label.
        JLabel lblUserConstructor = new JLabel("<html>User fill constructor<br/>" +
                "----------<br/><html>"
                + e4.getHTML());

        // Add GUI elements.
        pane.add(lblDefaultConstructor);
        pane.add(lblFillConstructor);
        pane.add(lblCopyConstructor);
        pane.add(lblUserConstructor);

        // Set location of labels.
        lblDefaultConstructor.setLocation(20,5);
        lblFillConstructor.setLocation(190, 5);
        lblCopyConstructor.setLocation(430,5);
        lblUserConstructor.setLocation(670,5);

        // Set size of labels.
        lblDefaultConstructor.setSize(250,150);
        lblFillConstructor.setSize(250,150);
        lblCopyConstructor.setSize(250,150);
        lblUserConstructor.setSize(250,150);

        // Make the GUI visible to the user.
        GUI.setVisible(true);

        // Command line version of Employee.
        /*// Default constructor test.
        Employee e1 = new Employee();
        System.out.println("Default constructor" + "\n" +
                "-----------" + "\n" +
                e1.getString() + "\n");

        // Fill constructor test.
        Employee e2 = new Employee("Jack", "Margeson", 8, 12.00, 605555);
        System.out.println("Fill constructor" + "\n" +
                "-----------" + "\n" +
                e2.getString() + "\n");

        // Copy constructor test.
        // Employee e2 -> employee e3.
        Employee e3 = new Employee(e2);
        System.out.println("Copy constructor" + "\n" +
                "-----------" + "\n" +
                e3.getString() + "\n");

        // User inputted test (fill constructor).
        System.out.println("Enter first name:");
        String first = scanner.nextLine();
        System.out.println("Enter last name:");
        String last = scanner.nextLine();
        System.out.println("Enter hours worked:");
        int hours = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter salary:");
        double salary = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter ID:");
        int id = Integer.parseInt(scanner.nextLine());
        Employee e4 = new Employee(first, last, hours, salary, id);
        System.out.println("Fill constructor (from user input)" + "\n" +
                "-----------" + "\n" +
                e4.getString() + "\n"); */
    }
}