/* Matrix.java
Matrix class for Matrix Lab.
Jack Margeson, 11/11/2019 */

import java.awt.desktop.SystemEventListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
    // File constructor.
    public Matrix(String filename) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String input;
            int i = 0, j = 0;
            int width = 0, height = 0;
            while ((input = br.readLine()) != null) {
                if (i == 0) {
                    width = Integer.parseInt(input);
                    i++;
                } else if (i == 1) {
                    height = Integer.parseInt(input);
                    this.matrix = new int[width][height];
                    i++;
                } else {
                    System.out.println("Nuts");
                }
            }
        } catch(IOException err) {
            System.err.println("IO error.");
        }
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
    // Compares two matrices and returns a boolean based on if they can be operated with addition and subtraction.
    public boolean check(Matrix matrix) {
        return this.getWidth() == matrix.getWidth() && this.getHeight() == matrix.getHeight();
    }

    // checkMultiplication(Matrix matrix);
    // Compares two matrices and returns a boolean based on if they can be operated with multiplication.
    public boolean checkMultiplication(Matrix matrix) {
        return matrix.getHeight() == this.getWidth();
    }

    // add(Matrix matrix);
    // Adds one matrix to another and returns the result matrix.
    public Matrix add(Matrix matrix) {
        if (check(matrix)) {
            Matrix sum = new Matrix(this.getWidth(), this.getHeight());
            for (int i = 0; i < this.getHeight(); i++) {
                for (int j = 0; j < this.getWidth(); j++) {
                    sum.setEntry(j-1, i-1, this.getEntry(j, i) + matrix.getEntry(j, i));
                }
            }
            return sum;
        } else {
            return null;
        }
    }

    // subtract(Matrix matrix);
    // Subtracts one matrix to another and returns the result matrix.
    public Matrix subtract(Matrix matrix) {
        if (check(matrix)) {
            Matrix result = new Matrix(this.getWidth(), this.getHeight());
            for (int i = 0; i < this.getHeight(); i++) {
                for (int j = 0; j < this.getWidth(); j++) {
                    result.setEntry(j, i, this.getEntry(j, i) - matrix.getEntry(j, i));
                }
            }
            return result;
        } else {
            return null;
        }
    }

    // scalar(int scalar);
    // Multiplies each element in the matrix by the same number (scalar multiplication).
    public Matrix scalar(int scalar) {
        Matrix result = new Matrix(this.getWidth(), this.getHeight());
        for (int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                result.setEntry(j, i, this.getEntry(j, i) * scalar);
            }
        }
        return result;
    }

    // multiply(Matrix matrix);
    // Multiplies one matrix to another and returns the result matrix.
    public Matrix multiply(Matrix matrix) {
        if (checkMultiplication(matrix)) {
            Matrix result = new Matrix(matrix.getWidth(), this.getHeight());
            for (int i = 0; i < result.getHeight(); i++) {
                for (int j = 0; j < result.getWidth(); j++) {
                    int value = 0;
                    for (int k = 0; k < this.getWidth(); k++) {
                        value += this.getEntry(k, i) * matrix.getEntry(j, k);
                    }
                    result.setEntry(j, i, value);
                }
            }
            return result;
        } else {
            return null;
        }
    }

    // format();
    // Returns matrix in JTable readable format.
    public String[][] format() {
        String[][] string = new String[this.getWidth()][this.getHeight()];
        for (int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                string[j][i] = Integer.toString(this.getEntry(j, i));
            }
        }
        return string;
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
