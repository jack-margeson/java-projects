/* Payroll.java
Payroll class for Payroll project.
Jack Margeson, 09/25/2019 */

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Payroll {
    // Private data.
    private PayrollEmployee[] my_employees;

    // Constructors.
    // Default (random) constructor.
    Payroll(int i, String ffirst, String flast) {
        PayrollEmployee[] e = new PayrollEmployee[i];
        String[] first = new String[101];
        String[] last = new String[101];
        Random r = new Random();

        // Load first names from file.
        try {
            Scanner scanner = new Scanner(new File(ffirst));
            int j = 0;
            while (scanner.hasNextLine()) {
                first[j] = scanner.nextLine();
                j++;
            }
        } catch (FileNotFoundException err) {
            err.printStackTrace();
        }
        // Load last names from file.
        try {
            Scanner scanner = new Scanner(new File(flast));
            int j = 0;
            while (scanner.hasNextLine()) {
                last[j] = scanner.nextLine();
                j++;
            }
        } catch (FileNotFoundException err) {
            err.printStackTrace();
        }

        // Assign employee data.
        for (int k = 0; k < i; k++) {
            e[k] = new PayrollEmployee(first[r.nextInt(100) + 1], // first name
                    last[r.nextInt(100) + 1], // last name
                    (r.nextInt(12) + 5) * 365, // hours
                    (Math.round(((r.nextDouble() * 27.16) + 7.00)*100.0))/100.0, // salary
                    1001 + k, // id number
                    r.nextInt(20) + 1, // years worked
                    r.nextInt(4) + 1); // dependants
        }
        // Return array of employees.
        my_employees = e;
    }
    // saveEmployees
    public void saveEmployees(String filename) {
        try {
            Writer writer = new FileWriter(filename);
            for (int i = 0; i < this.my_employees.length;i++) {
                writer.write(my_employees[i].getMy_first() + ", " +
                        my_employees[i].getMy_last() + ", " +
                        my_employees[i].getMy_hours() + ", " +
                        my_employees[i].getMy_salary() + ", " +
                        my_employees[i].getMy_id() + ", " +
                        my_employees[i].getMy_years() + ", " +
                        my_employees[i].getMy_dependents() + "\n");
            }
            writer.flush();
            writer.close();
        } catch (IOException err){
            err.printStackTrace();
        }
    }

    // Gets and sets.
    // Gets.
    public PayrollEmployee[] getMy_employees() {
        return my_employees;
    }
    // Sets.
    public void setMy_employees(PayrollEmployee[] my_employees) {
        this.my_employees = my_employees;
    }

    // Member functions.
    // runPayroll
    // Fills an array of pay stubs.
    public String[] runPayroll() {
        String[] PayrollEmployePaystubs = new String[my_employees.length];
        for (int i = 0; i < my_employees.length; i++) {
            PayrollEmployePaystubs[i] = "Gross Pay: " + my_employees[i].findGrossPay() + "\n" +
                    "Federal tax: " + my_employees[i].findFed() + "\n" +
                    "State tax: " + my_employees[i].findState() + "\n" +
                    "Local tax: " + my_employees[i].findLocal() + "\n" +
                    "Social Security Pay: " + my_employees[i].findSocialSecurity() + "\n" +
                    "Net Pay: " + my_employees[i].findNetPay() + "\n";
        }
        return(PayrollEmployePaystubs);
    }
    // getString()
    // Returns a string of employees.
    public String[] getStrings() {
        String[] strings = new String[my_employees.length];
        String[] paystub = runPayroll();
        for (int i = 0; i < my_employees.length; i++) {
            strings[i] = my_employees[i].toString() + paystub[i];
        }
        return(strings);
    }
}