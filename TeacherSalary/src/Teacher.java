/* TeacherSalary.java
Teacher class 4.1 lab written in Java.
Jack Margeson, 09/24/2019 */

public class Teacher {
    // Private data.
    double my_base_salary;
    int my_years;
    String my_degree;
    double my_salary;

    // Constructors.
    // Default constructor.
    public Teacher() {
        this.my_base_salary = 0;
        this.my_years = 0;
        this.my_degree = "";
        this.my_salary = 0;
    }
    // Fill constructor.
    public Teacher(double base_salary, int years, String degree, double salary) {
        this.my_base_salary = base_salary;
        this.my_years = years;
        this.my_degree = degree;
        this.my_salary = salary;
    }
    // Copy constructor.
    public Teacher(Teacher t1) {
        this.my_base_salary = t1.my_base_salary;
        this.my_years = t1.my_years;
        this.my_degree = t1.my_degree;
        this.my_salary = t1.my_salary;
    }

    // Gets and sets.
    // Gets.
    public double getMy_salary() {
        return my_base_salary;
    }
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
    public void setMy_salary(double my_salary) {
        this.my_base_salary = my_salary;
    }
    public void setMy_years(int my_years) {
        this.my_years = my_years;
    }
    public void setMy_degree(String my_degree) {
        this.my_degree = my_degree;
    }
    public void setMy_base_salary(double my_base_salary) {
        this.my_base_salary = my_base_salary;
    }

    String toHTML() {
        return("<html>" + "Teacher" + "<br>" + "----------" + "<br>" +
                "Base Salary: " + this.my_base_salary + "<br>" +
                "Years: " + this.my_years + "<br>" +
                "Degree: " + this.my_degree + "<br>" +
                "Salary: " + this.my_salary + "</html>");
    }
}
