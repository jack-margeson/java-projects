/* PayrollTest.java
Payroll class tester for Payroll project.
Jack Margeson, 09/25/2019 */

import javax.swing.*;
import java.awt.*;

public class PayrollTest {
    public static JFrame GUI = new JFrame();
    public static JTable table = new JTable();
    private static Container pane = GUI.getContentPane(); // pane declaration from Container.
    private static JLabel companyTotalLabel = new JLabel();
    public static int hm = 100;
    public static Payroll payroll = new Payroll(hm, "first.txt", "last.txt");

    public static void main(String[] args) {
        // Give properties to the GUI.
        GUI.setTitle("Payroll");
        GUI.setSize(1200, 600);
        GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Give properties to the pane.
        pane.setBackground(new Color(163, 255, 188));
        pane.setLayout(null);

        // Set table.
        String[] tableTitles = new String[]{"Name", "Hours Worked", "Salary", "ID", "Years worked", "Dependents", "Gross Pay", "Federal tax", "State tax", "Local tax", "Social Security tax", "Net Pay"};
        table = new JTable(getTable(), tableTitles);
        // JTable properties.
        table.setLocation(0,0);
        table.setSize(1200,500);

        // Create JScrollPane and give it properties.
        JScrollPane scroll = new JScrollPane(table);
        scroll.setLocation(0, 0);
        scroll.setSize(1200, 500);

        double companyTotal = 0.0;
        for (int i = 0; i < hm; i++) {
            System.out.println(payroll.getStrings()[i]);
            companyTotal += payroll.getMy_employees()[i].findGrossPay();
        }
        final String text = "The company has paid out $" + (Math.round(companyTotal * 100.00) / 100.00) + " this year.";
        System.out.println(text);

        // Set company payment label.
        companyTotalLabel = new JLabel(text);
        // Label properties.
        companyTotalLabel.setSize(1200, 100);
        companyTotalLabel.setLocation(0, 500);

        // Add GUI elements.
        GUI.add(scroll);
        GUI.add(companyTotalLabel);

        // Make the GUI visible to the user.
        GUI.setVisible(true);
    }

    static String[][] getTable() {
        String[][] table = new String[hm][12];
        for (int i = 0; i < hm; i++) {
            table[i][0] = payroll.getMy_employees()[i].getMy_first() + " " + payroll.getMy_employees()[i].getMy_last();
            table[i][1] = String.valueOf(payroll.getMy_employees()[i].getMy_hours());
            table[i][2] = String.valueOf(payroll.getMy_employees()[i].getMy_salary());
            table[i][3] = String.valueOf(payroll.getMy_employees()[i].getMy_id());
            table[i][4] = String.valueOf(payroll.getMy_employees()[i].getMy_years());
            table[i][5] = String.valueOf(payroll.getMy_employees()[i].getMy_dependents());
            table[i][6] = String.valueOf(payroll.getMy_employees()[i].findGrossPay());
            table[i][7] = String.valueOf(payroll.getMy_employees()[i].findFed());
            table[i][8] = String.valueOf(payroll.getMy_employees()[i].findState());
            table[i][9] = String.valueOf(payroll.getMy_employees()[i].findLocal());
            table[i][10] = String.valueOf(payroll.getMy_employees()[i].findSocialSecurity());
            table[i][11] = String.valueOf(payroll.getMy_employees()[i].findNetPay());
        }
        return(table);
    }

}
