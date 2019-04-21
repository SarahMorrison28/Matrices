package cpsc2150.matrixFun;

public class Matrix {

    /**
     * Invariants: 0 < rows < 10 and 0 < cols < 10
     *
     */

    int[][] values;
    int rows;
    int cols;

    /**
     *
     * @param rows_x - number of rows in the array
     * @param cols_x - number of columns in the array
     * @param array - 2d matrix of integers
     * @pre - see invariants
     * @post - matrix will be constructed with rows, columns, and 2d array
     */

    Matrix(int rows_x, int cols_x, int[][] array){
        this.rows = rows_x;
        this.cols = cols_x;
        this.values = array;

    }

    /**
     *
     * @param two - Matrix that gets passed into the function to add to matrix
     *            the function is called on
     * @return - returns one Matrix that is the addition of the two matrices
     * @pre - matrices must have same dimensions
     * @post - final matrix will have same dimensions as the two matrices passed in
     *
     */
    public Matrix add(Matrix two)
    {
        int[][] array = new int[this.getRows()][this.getCols()];
        Matrix finalMatrix = new Matrix(two.getRows(), two.getCols(), array);
        for(int i=0; i< two.getRows(); i++){
            for(int j=0; j< two.getCols(); j++){
                finalMatrix.values[i][j] = this.values[i][j] + two.values[i][j];
            }
        }

        return finalMatrix;

    }

    /**
     *
     * @param two - Matrix that will be subtracted from the matrix that the function
     *            is called on
     * @return - returns one Matrix that is the difference of the two matrices
     * @pre - matrices must have same dimensions
     * @post - final Matrix will have same dimensions as the two matrices passed in
     */
    public Matrix subtract(Matrix two)
    {
        int[][] array = new int[this.getRows()][this.getCols()];
        Matrix finalMatrix = new Matrix(two.getRows(), two.getCols(), array);
        for(int i=0; i < two.getRows(); i++){
            for(int j=0; j< two.getCols(); j++){
                finalMatrix.values[i][j] = this.values[i][j] - two.values[i][j];
            }
        }

        return finalMatrix;
    }

    /**
     *
     * @return - returns one Matrix that is the transposition of the matrix the
     *          function is called on
     * @post - final Matrix will have the opposite dimensions of the original
     */
    public Matrix transpose()
    {
        int[][] array = new int[this.getRows()][this.getCols()];
        Matrix finalMatrix = new Matrix(this.getRows(), this.getCols(), array);
        for(int i=0; i<this.getRows(); i++){
            for(int j=0; j<this.getCols(); j++){
                finalMatrix.values[j][i] = this.values[i][j];
            }
        }
        return finalMatrix;
    }

    /**
     *
     * @return - the number of rows in the matrix
     */
    public int getRows()
    {
        return this.rows;
    }

    /**
     *
     * @return - the number of columns in the matrix
     */
    public int getCols()
    {
        return this.cols;
    }

}
