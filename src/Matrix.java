public class Matrix {
    private int rows;
    private int cols;
    private int[][] elements;

    public Matrix(int rows, int cols, int[][] elements) {
        this.rows = rows;
        this.cols = cols;
        this.elements = new int[rows][cols];
        preencherMatrix(elements);
    }

    public void preencherMatrix(int[][] elements) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.elements[i][j] = elements[i][j];
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public int[][] getElements() {
        return elements;
    }

    public int getPosition(int i, int j) {
        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            throw new IndexOutOfBoundsException("Índice fora dos limites da matriz.");
        }
        return elements[i][j];
    }

    public void setPosition(int i, int j, int value) {
        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            throw new IndexOutOfBoundsException("Índice fora dos limites da matriz.");
        }
        elements[i][j] = value;
    }

    public void imprimirMatriz() {
        for (int i = 0; i < getRows(); i++) {
            System.out.print("[ ");
            for (int j = 0; j < getCols(); j++) {
                System.out.print(" " + getPosition(i, j) + " ");
            }
            System.out.println(" ]");
        }
    }
}