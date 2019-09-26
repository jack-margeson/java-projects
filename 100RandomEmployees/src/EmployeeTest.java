/* Employee.java
Employee class for 100RandomEmployees lab.
Jack Margeson, 09/25/2019 */

public class EmployeeTest {
    public static void main(String[] args) {
        // Generate list of employees.
        Employee[] e1 = new EmployeeGenerator(100).getMy_employees();

        for (int i = 0; i < 100; i++) {
            System.out.println(e1[i].toString());
        }
    }
}