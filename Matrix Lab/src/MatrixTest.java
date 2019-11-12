public class MatrixTest {
    public static void main(String[] args) {
        // Create three matrices used for calculation.
        Matrix m1 = new Matrix(3, 3);
        Matrix m2 = new Matrix(3, 3);
        Matrix m3 = new Matrix();

        // Create data for matrix 1 and matrix 2.
        int cc = 0;
        for (int i = 0; i < m1.getHeight(); i++) {
            for (int j = 0; j < m1.getWidth(); j++) {
                cc++;
                m1.setEntry(j, i, cc);
                m2.setEntry(j, i, cc);
            }
        }

        // Print the values of all of the matrices.
        System.out.println("Matrix 1:\n" + m1);
        System.out.println("Matrix 2:\n" + m2);
        System.out.println("Matrix 3:\n" + m3);

        // Create answer matrix.
        Matrix answer;

        // Adding matrix 1 and 2 should correctly output the answer matrix.
        answer = m1.add(m2);
        System.out.println("Sum of m1 and m2:");
        if (answer != null) { System.out.println(answer); } else { System.out.println("These matrices cannot be added."); }

        // Adding matrix 2 and 3 should correctly state that the matrices cannot be added.
        answer = m2.add(m3);
        System.out.println("Sum of m2 and m3:");
        if (answer != null) { System.out.println(answer); } else { System.out.println("These matrices cannot be added."); }
    }
}
