/* Employee.java
A test of classes and importation in Java, with employees.
Jack Margeson 05/15/2019 */

public class Employee {
	// variable declaration 
	String name;
	int age;
	String job;
	double salary;

	// Employee constructor - passes in a String for name 
	public Employee(String name) {
		this.name = name;
	}

	// Set methods 
	// Employee.employeeAge
	public void employeeAge(int age) {
		this.age = age;
	}
	// Employee.employeeJob
	public void employeeJob(String job) {
		this.job = job;
	}
	// Employee.employeeSalary
	public void employeeSalary(double salary) {
		this.salary = salary;
	}
	// Employee.printEmployee
	public void printEmployee() { 
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Job: " + job);
		System.out.println("Salary: $" + salary);
	}
}
