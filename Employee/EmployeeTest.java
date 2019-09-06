/* EmployeeTest.java
A test of classes and importation in Java, with employees.
Jack Margeson 05/15/2019 */


public class EmployeeTest {
	public static void main(String args[]) {
		// declaration
		Employee e1 = new Employee("Jack Margeson");
		Employee e2 = new Employee("Jonah Calvert");

		// employee 1 
		e1.employeeAge(16);
		e1.employeeJob("Computer Programmer");
		e1.employeeSalary(160000);
		e1.printEmployee();

		// employee 2 
		e2.employeeAge(16);
		e2.employeeJob("Computer Programmer");
		e2.employeeSalary(150000);
		e2.printEmployee();
	}
}
