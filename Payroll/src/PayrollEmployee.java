/* PayrollEmployee.java
PayrollEmployee class for Payroll project.
Jack Margeson, 09/25/2019 */

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
    // findGrossPay
    // Returns gross pay.
    public double findGrossPay() {
        return Math.round((getMy_hours() * getMy_salary())*100.00) / 100.00;
    }
    // findFed
    // Return federal tax.
    public double findFed() {
        double tax = 0.0;
        if (this.findGrossPay() <= 9525.00) {
            tax = (.10 * this.findGrossPay()); // 10%
        } else if (this.findGrossPay() > 9525.00 && this.findGrossPay() <= 38700.00) {
            tax = (952.50 + ((this.findGrossPay() - 9525.00) * .12)); // 12%
        } else if (this.findGrossPay() > 38700.00 && this.findGrossPay() <= 82500.00) {
            tax = (4453.50 + ((this.findGrossPay() - 38700.00) * .22)); // 22%
        } else if (this.findGrossPay() > 82500.00 && this.findGrossPay() <= 157500.00) {
            tax = (14089.50 + ((this.findGrossPay() - 82500.00) * .24)); // 24%
        } else if (this.findGrossPay() > 157500.00 && this.findGrossPay() <= 200000.00) {
            tax = (32089.50 + ((this.findGrossPay() - 157500.00) * .32)); // 32%
        } else if (this.findGrossPay() > 200000.00 && this.findGrossPay() <= 500000.00) {
            tax = (150689.50 + ((this.findGrossPay() - 500000.00) * .37)); // 37%
        } else {
            return(0.0); // Kummer's bracket
        }
        return(Math.round(((tax - (my_dependents * 100)) * 100.00 ) / 100.00));
    }
    // findState
    // Returns state tax.
    public double findState() {
        double tax = 0.0;
        if (this.findGrossPay() <= 5200.00) {
            tax = (.00495 * this.findGrossPay());
        } else if (this.findGrossPay() > 5200.00 && this.findGrossPay() <= 10400.00) {
            tax = (.00990 * this.findGrossPay());
        } else if (this.findGrossPay() > 10400.00 && this.findGrossPay() <= 15650.00) {
            tax = (.01980 * this.findGrossPay());
        } else if (this.findGrossPay() > 15650.00 && this.findGrossPay() <= 20900.00) {
            tax = (.02476 * this.findGrossPay());
        } else if (this.findGrossPay() > 20900.00 && this.findGrossPay() <= 41700.00) {
            tax = (.03465 * this.findGrossPay());
        } else if (this.findGrossPay() > 41700.00 && this.findGrossPay() <= 83350.00) {
            tax = (.03960 * this.findGrossPay());
        } else if (this.findGrossPay() > 83350.00 && this.findGrossPay() <= 104250.00) {
            tax = (.04597 * this.findGrossPay());
        } else if (this.findGrossPay() > 104250.00 && this.findGrossPay() <= 208501.00) {
            tax = (.04597 * this.findGrossPay());
        } else if (this.findGrossPay() > 208501.00) {
            tax = (.04997 * this.findGrossPay());
        } else {
            return(0.0); // Kummer's bracket
        }
        return(Math.round(tax * 100.00) / 100.00);
    }
    // findLocal
    // Returns local tax.
    public double findLocal() {
        return(Math.round((this.findGrossPay() * .0112) * 100.00) / 100.00);
    }
    // findSocialSecurity
    // Returns social security tax.
    public double findSocialSecurity() {
        return(Math.round((this.findGrossPay() * .062) * 100.00) / 100.00);
    }
    public double findNetPay() {
        return(((this.findGrossPay() - this.findFed() - this.findState() - this.findLocal() - this.findSocialSecurity()) * 100.00) / 100.00);
    }

    // toString
    // Returns a string of the employee.
    @Override
    public String toString() {
        return(super.toString() + "Dependents: " + this.my_dependents + "\n");
    }
}
