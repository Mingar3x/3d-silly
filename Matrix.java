//this is a dynamic matrix class that can make matrices of any size
//pretty cool, yuh?
public class Matrix {
    int rows;
    int columns;
    double[][] array;

    //useless ahh constructor ↓↓
    public Matrix (int w, int h) {
        array = new double[h][w];
    }
    
    public Matrix(double[][] data) {
        this.rows = data.length;
        this.columns = data[0].length;
        this.array = new double[rows][columns];
        //this loop ↓↓ copies the inputed data into this matrix object
        for (int i = 0; i < rows; i++) {
            System.arraycopy(data[i], 0, this.array[i], 0, columns);
        }
    }

    public double get(int row, int column) {
        if (row < 0 || row >= rows || column < 0 || column >= columns) {
            throw new IndexOutOfBoundsException("Index out of bounds: (" + row + ", " + column + ")");
        }
        return array[row][column];
    }
    //
    public void display() { //this method ↓↓ prints the matrix to the console
        for (double[] row : array) {
            for (double value : row) {
                System.out.print(value + "\t"); // \t is a tab character btw 
            }
            System.out.println();
        }
    }
    public void set(int row, int column, double value) {
        array[row][column] = value;
    }

    // Get number of rows
    public int getRows() {
        return rows;
    }

    // Get number of columns
    public int getColumns() {
        return columns;
    }

    //matrix multiplication
    public Matrix multiply(Matrix other) {

        //important ↓↓
        if (this.columns != other.rows) {
            System.out.println("BEEP BEEP BEEP THESE MATRICES CANT BE MULTLIPLIETed");
            System.out.println("-----------------");
            System.out.println("the problematic matrices were the following:");
            System.out.println("Matrix 1:");
            this.display();
            System.out.println("Matrix 2:");
            other.display();
        }

        Matrix result = new Matrix(other.columns, this.rows);

        // Perform the multiplication
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.columns; j++) {
                double sum = 0;
                for (int k = 0; k < this.columns; k++) {
                    sum += this.array[i][k] * other.array[k][j];
                }
                result.set(i, j, sum);
            }
        }

        return result;
    }
}
