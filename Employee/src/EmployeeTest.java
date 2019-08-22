/* EmployeeTest.java
An employee class tester in Java.
Jack Margeson, 08/22/2019 */

// Imports.
import java.util.Scanner;

public class EmployeeTest {
    // Declarations and init.
    private static Scanner scanner = new Scanner(System.in); // Scanner obj. from Scanner.

    // Main.
    public static void main(String[] args) {
        // Default constructor test.
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
                e4.getString() + "\n");
    }
}