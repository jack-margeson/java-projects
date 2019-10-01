public class PayrollEmployee extends Employee {
    // Private data.
    private int my_dependents;

    // Constructors.
    // Default constructor.
    public PayrollEmployee(int my_dependents) {
        this.my_dependents = my_dependents;
    }
    // Fill constructor using super().
    public PayrollEmployee(String my_first, String my_last, int my_hours, double my_salary, int my_id, int my_years, int my_dependents) {
        super(my_first, my_last, my_hours, my_salary, my_id, my_years);
        this.my_dependents = my_dependents;
    }

    // Gets and sets.
    // Gets.
    public int getMy_dependents() {
        return my_dependents;
    }
    // Sets.
    public void setMy_dependents(int my_dependents) {
        this.my_dependents = my_dependents;
    }

    // Member functions.
    // toString
    // Returns a string of the employee.
    public String toString() {
        return("Name: " + super.getMy_first() + " " + super.getMy_last() + "\n" +
                "Hours worked: " + super.getMy_hours() + "\n" +
                "Salary: $" + super.getMy_salary() + "\n" +
                "ID: " + super.getMy_id() + "\n" +
                "Years worked: " + super.getMy_years() + "\n" +
                "Dependants: " + this.my_dependents + "\n");
    }
}
