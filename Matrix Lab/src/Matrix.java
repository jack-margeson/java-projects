/* Matrix.java
Matrix class for Matrix Lab.
Jack Margeson, 11/11/2019 */

public class Matrix {
    // Private data.
    private int[][] matrix;

    // Constructors.
    // Default constructor.
    public Matrix() {
        this.matrix = new int[2][2];
    }
    // Fill constructor.
    public Matrix(int width, int height) {
        this.matrix = new int[width][height];
    }

    // Gets and sets.
    public int[][] getMatrix() {
        return matrix;
    }
    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
    public int getWidth() {
        return matrix.length;
    }
    public int getHeight() {
        return matrix[0].length;
    }
    public void setEntry(int width, int height, int i) {
        this.matrix[width][height] = i;
    }
    public int getEntry(int width, int height) {
        return matrix[width][height];
    }

    // Member functions.
    // check(Matrix matrix);
    // Compares two matrices and returns a boolean based on if they can be operated.
    public boolean check(Matrix matrix) {
        return this.getWidth() == matrix.getWidth() && this.getHeight() == matrix.getHeight();
    }

    // add(Matrix matrix);
    // Adds one matrix to another and returns the result matrix.
    public Matrix add(Matrix matrix) {
        if (check(matrix)) {
            Matrix sum = new Matrix(this.getWidth(), this.getHeight());
            for (int i = 0; i < this.getHeight(); i++) {
                for (int j = 0; j < this.getWidth(); j++) {
                    sum.setEntry(j, i, this.getEntry(j, i) + matrix.getEntry(j, i));
                }
            }
            return sum;
        } else {
            return null;
        }
    }

    // toString();
    // Gets matrix in string form.
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                s.append(this.getEntry(j,i)).append(" ");
            }
            s.append("\n");
        }
        return s.toString();
    }
}
