/* Employee.java
Employee class for Payroll project.
Jack Margeson, 09/25/2019 */

public class Employee {
    // Private data.
    private String my_first;
    private String my_last;
    private int my_hours;
    private double my_salary;
    private int my_id;
    private int my_years;

    // Constructors.
    // Default constructor.
    Employee() {
        this.my_first = "";
        this.my_last = "";
        this.my_hours = 0;
        this.my_salary = 0;
        this.my_id = 0;
        this.my_years = 0;
    }
    // Fill constructor.
    public Employee(String my_first, String my_last, int my_hours, double my_salary, int my_id, int my_years) {
        this.my_first = my_first;
        this.my_last = my_last;
        this.my_hours = my_hours;
        this.my_salary = my_salary;
        this.my_id = my_id;
        this.my_years = my_years;
    }

    // Gets and sets.
    // Gets.
    public String getMy_first() {
        return my_first;
    }
    public String getMy_last() {
        return my_last;
    }
    public int getMy_hours() {
        return my_hours;
    }
    public double getMy_salary() {
        return my_salary;
    }
    public int getMy_id() {
        return my_id;
    }
    public int getMy_years() {
        return my_years;
    }
    // Sets.
    public void setMy_first(String my_first) {
        this.my_first = my_first;
    }
    public void setMy_last(String my_last) {
        this.my_last = my_last;
    }
    public void setMy_hours(int my_hours) {
        this.my_hours = my_hours;
    }
    public void setMy_salary(double my_salary) {
        this.my_salary = my_salary;
    }
    public void setMy_id(int my_id) {
        this.my_id = my_id;
    }
    public void setMy_years(int my_years) {
        this.my_years = my_years;
    }

    // Member functions.
    // toString
    // Returns a string of the employee.
    @Override
    public String toString() {
        return("Name: " + this.my_first + " " + this.my_last + "\n" +
                "Hours worked: " + this.my_hours + "\n" +
                "Salary: $" + this.my_salary + "\n" +
                "ID: " + this.my_id + "\n" +
                "Years worked: " + this.my_years + "\n");
    }
}