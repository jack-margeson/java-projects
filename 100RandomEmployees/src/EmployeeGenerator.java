import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;
import java.util.Random;

public class EmployeeGenerator {
    // Private data.
    private PayrollEmployee[] my_employees;

    // Constructors.
    // Default (random) constructor.
    EmployeeGenerator(int i) {
        PayrollEmployee[] e = new PayrollEmployee[i];
        String[] first = new String[101];
        String[] last = new String[101];
        Random r = new Random();

        // Load first names from file.
        try {
            Scanner scanner = new Scanner(new File("./src/first.txt"));
            int j = 0;
            while (scanner.hasNextLine()) {
                first[j] = scanner.nextLine();
                j++;
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        // Load last names from file.
// Load first names from file.
        try {
            Scanner scanner = new Scanner(new File("./src/last.txt"));
            int j = 0;
            while (scanner.hasNextLine()) {
                last[j] = scanner.nextLine();
                j++;
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        // Assign employee data.
        for (int k = 0; k < i; k++) {
            e[k] = new PayrollEmployee(first[r.nextInt(100) + 1], // first name
                    last[r.nextInt(100) + 1], // last name
                    r.nextInt(24) + 1, // hours
                    (Math.round((r.nextDouble() * 100000)*100.0))/100.0, // salary
                    1001 + k, // id number
                    r.nextInt(20) + 1, // years worked
                    r.nextInt(11) + 1); // dependants
        }
        // Return array of employees.
        my_employees = e;
    }

    // Gets and sets.
    // Gets.
    public PayrollEmployee[] getMy_employees() {
        return my_employees;
    }
    // Sets.
    public void setMy_employees(PayrollEmployee[] my_employees) {
        this.my_employees = my_employees;
    }
}
