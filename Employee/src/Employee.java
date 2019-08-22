/* Employee.java
An employee class in Java.
Jack Margeson, 08/22/2019 */

public class Employee {
    // Data
    private String my_first;
    private String my_last;
    private int my_hours;
    private double my_salary;
    private int my_id;

    // Constructors for Employee.
    // Default constructor
    Employee() {
        my_first = "";
        my_last = "";
        my_hours = 0;
        my_salary = 0.0;
        my_id = 0;
    }

    // Fill constructor
    Employee(String first, String last, int hours, double salary, int id) {
        my_first = first;
        my_last = last;
        my_hours = hours;
        my_salary = salary;
        my_id = id;
    }

    // Copy constructor
    Employee(Employee employee) {
        my_first = employee.my_first;
        my_last = employee.my_last;
        my_hours = employee.my_hours;
        my_salary = employee.my_salary;
        my_id = employee.my_id;
    }

    // Set functions for Employee.
    // employee.setFirst("Jack");
    void setFirst(String first) {
        my_first = first;
    }
    // employee.setLast("Margeson");
    void setLast(String last) {
        my_last = last;
    }
    // employee.setHours("8");
    void setHours(int hours) {
        my_hours = hours;
    }
    // employee.setSalary("15.00");
    void setSalary(double salary) {
        my_salary = salary;
    }
    // employee.setID("555555");
    void setID(int ID) {
        my_id = ID;
    }

    // Get functions for Employee
    // employee.getFirst();
    String getFirst() {
        return(my_first);
    }
    // employee.getLast()
    String getLast() {
        return(my_last);
    }
    // employee.getHours()
    int getHours() {
        return(my_hours);
    }
    // employee.getSalary()
    double getSalary() {
        return(my_salary);
    }
    // employee.getID()
    int getID() {
        return(my_id);
    }
    // employee.getGrossPay();
    double getGrossPay() {
        return(my_hours * my_salary);
    }
    // employee.getString();
    String getString() {
        return("Name: " + my_first + " " + my_last + "\n" +
                "Hours worked: " + Integer.toString(my_hours) + "\n" +
                "Salary: $" + Double.toString(my_salary) + "\n" +
                "Gross Pay: $" + getGrossPay() + "\n" +
                "ID: " + Integer.toString(my_id));
    }
}
