/* Matrix.java
Matrix class for Matrix Lab.
Jack Margeson, 11/11/2019 */

import java.awt.desktop.SystemEventListener;

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
