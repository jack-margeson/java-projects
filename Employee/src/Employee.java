/* Employee.java
An employee class in Java.
Jack Margeson, 08/23/2019 */

import java.math.BigDecimal;
import java.math.RoundingMode;

class Employee {
    // Data
    private String my_first;
    private String my_last;
    private String my_nickname;
    private int my_hours;
    private double my_salary;
    private int my_id;
    private int my_years;

    // Constructors for Employee.
    // Default constructor
    Employee() {
        my_first = "";
        my_last = "";
        my_nickname = "";
        my_hours = 0;
        my_salary = 0.0;
        my_id = 0;
        my_years = 0;
    }

    // Fill constructor
    Employee(String first, String last, String nickname, int hours, double salary, int id, int years) {
        my_first = first;
        my_last = last;
        my_nickname = nickname;
        my_hours = hours;
        my_salary = salary;
        my_id = id;
        my_years = years;
    }

    // Copy constructor
    Employee(Employee employee) {
        my_first = employee.my_first;
        my_last = employee.my_last;
        my_nickname = employee.my_nickname;
        my_hours = employee.my_hours;
        my_salary = employee.my_salary;
        my_id = employee.my_id;
        my_years = employee.my_years;
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
    // employee.setLast("Margeson");
    void setNickname(String nickname) {
        my_nickname = nickname;
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
    // employee.setYears("2");
    void setYears(int years) {
        my_years = years;
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
    // employee.getNickname()
    String getNickname() {
        return(my_nickname);
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
    // employee.getID()
    int getYears() {
        return(my_years);
    }

    // employee.getGrossPay();
    double getGrossPay() {
        return(my_hours * my_salary);
    }
    // employee.getString();
    String getString() {
        return("Name: " + my_first + " \"" + my_nickname + "\" " + my_last + "\n" +
                "Hours worked: " + Integer.toString(my_hours) + "\n" +
                "Salary: $" + Double.toString(my_salary) + "\n" +
                "Gross Pay: $" + getGrossPay() + "\n" +
                "ID: " + Integer.toString(my_id) + "\n" +
                "Years worked: " + Integer.toString(my_years));
    }
    String getHTML() {
        BigDecimal salary = new BigDecimal(my_salary)    .setScale(2, RoundingMode.HALF_UP);
        BigDecimal grossPay = new BigDecimal(getGrossPay()).setScale(2, RoundingMode.HALF_UP);

        return("<html>" + "Name: " + my_first + " \"" + my_nickname + "\" " + my_last + "<br/>" +
                "Hours worked: " + Integer.toString(my_hours) + "<br/>" +
                "Salary: $" + salary + "<br/>" +
                "Gross Pay: $" + grossPay + "<br/>" +
                "ID: " + Integer.toString(my_id) + "<br/>" +
                "Years worked: " + Integer.toString(my_years) + "<html>");
    }
}
