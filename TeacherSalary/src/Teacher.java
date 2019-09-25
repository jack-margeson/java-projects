/* TeacherSalary.java
Teacher class 4.1 lab written in Java.
Jack Margeson, 09/24/2019 */

public class Teacher {
    // Private data.
    double my_base_salary;
    int my_years;
    String my_degree;

    // Constructors.
    // Default constructor.
    public Teacher() {
        this.my_base_salary = 0;
        this.my_years = 0;
        this.my_degree = "";
    }
    // Fill constructor.
    public Teacher(double base_salary, int years, String degree) {
        this.my_base_salary = base_salary;
        this.my_years = years;
        this.my_degree = degree;
    }
    // Copy constructor.
    public Teacher(Teacher t1) {
        this.my_base_salary = t1.my_base_salary;
        this.my_years = t1.my_years;
        this.my_degree = t1.my_degree;
    }

    // Gets and sets.
    // Gets.
    public int getMy_years() {
        return my_years;
    }
    public String getMy_degree() {
        return my_degree;
    }
    public double getMy_base_salary() {
        return my_base_salary;
    }
    // Sets.
    public void setMy_years(int my_years) {
        this.my_years = my_years;
    }
    public void setMy_degree(String my_degree) {
        this.my_degree = my_degree;
    }
    public void setMy_base_salary(double my_base_salary) {
        this.my_base_salary = my_base_salary;
    }

    // Member functions.
    // getSalary
    // Returns the true salary of an employee.
    double getSalary(double base, double increase, int years) {
        return(base + (base * increase) + (years * 650));
    }
    // getIncrease
    // Returns the pay increase based on degree.
    double getIncrease() {
        double increase;
        switch (this.my_degree) {
            case "bachelors":
                increase = 0;
                break;
            case "masters":
                increase = .6;
                break;
            case "phd":
                increase = .9;
                break;
            default:
                increase = 0;
        }
        return(increase);
    }

    // String returns.
    // getSalaryTable
    // Returns an array of salaries based off of the base salary.
    String[][] getSalaryTable() {
        // Create table of salaries.
        String[][] table = new String[21][4];
        for (int i = 0; i <= 20; i++) {
            table[i][0] = String.valueOf(i); // Table index (years worked).
            table[i][1] = String.valueOf(getSalary(this.my_base_salary, 0, i)); // Bachelor's degree.
            table[i][2] = String.valueOf(getSalary(this.my_base_salary, .6, i)); // Master's degree.
            table[i][3] = String.valueOf(getSalary(this.my_base_salary, .9, i)); // PhD.
        }

        return(table);
    }
    // toHTML
    // Returns an HTML string for output in JFrame.
    String toHTML() {
        return("<html>" + "Teacher" + "<br>" + "----------" + "<br>" +
                "Base Salary: " + this.my_base_salary + "<br>" +
                "Years: " + this.my_years + "<br>" +
                "Degree: " + this.my_degree + "<br>" +
                "Salary: " + getSalary(this.my_base_salary, getIncrease(), my_years) + "</html>");
    }
}
