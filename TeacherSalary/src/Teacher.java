/* TeacherSalary.java
Teacher class 4.1 lab written in Java.
Jack Margeson, 09/24/2019 */

public class Teacher {
    // Private data.
    double my_salary;
    int my_years;
    String my_degree;

    // Constructors.
    // Default constructor.
    public Teacher() {
        this.my_salary = 0;
        this.my_years = 0;
        this.my_degree = "";
    }
    // Fill constructor.
    public Teacher(double salary, int years, String degree) {
        this.my_salary = salary;
        this.my_years = years;
        this.my_degree = degree;
    }
    // Copy constructor.
    public Teacher(Teacher t1) {
        this.my_salary = t1.my_salary;
        this.my_years = t1.my_years;
        this.my_degree = t1.my_degree;
    }

    // Gets and sets.
    // Gets.
    public double getMy_salary() {
        return my_salary;
    }
    public int getMy_years() {
        return my_years;
    }
    public String getMy_degree() {
        return my_degree;
    }
    // Sets.
    public void setMy_salary(double my_salary) {
        this.my_salary = my_salary;
    }
    public void setMy_years(int my_years) {
        this.my_years = my_years;
    }
    public void setMy_degree(String my_degree) {
        this.my_degree = my_degree;
    }

    String toHTML() {
        return("<html>" + "Teacher" + "<br>" + "----------" + "<br>" +
                "Salary: " + this.my_salary + "<br>" +
                "Years: " + this.my_years + "<br>" +
                "Degree: " + this.my_degree + "</html>");
    }
}
