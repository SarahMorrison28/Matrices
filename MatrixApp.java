package cpsc2150.matrixFun;

import java.util.Scanner;

public class MatrixApp {

    public static void main(String[] args)
    {
        int option;
        do{
        Scanner scanner = new Scanner(System.in);

        printMenu();

        //user's choice of what action to perform on the matrix/matrices
        option = Integer.parseInt(scanner.nextLine());

            //choice to transpose a matrix
            if (option == 1) {
                System.out.print("Enter number of rows: ");
                int rows = scanner.nextInt();
                while (rows <= 0 || rows > 10) {
                    System.out.print("Number of rows must be between 1 and 10\n");
                    System.out.print("Enter number of rows: ");
                    rows = scanner.nextInt();
                }
                System.out.print("Enter number of columns: ");
                int cols = scanner.nextInt();
                while (cols <= 0 || cols > 10) {
                    System.out.print("Number of cols must be between 1 and 10\n");
                    System.out.print("Enter number of cols: ");
                    cols = scanner.nextInt();
                }

                int[][] a = ReadMatrix(rows, cols);

                Matrix A = new Matrix(rows, cols, a);

                Matrix B = A.transpose();

                System.out.print("The transpose is: \n");
                printMatrix(B);
                System.out.println();

             //choice to add two matrices
            } else if (option == 2) {
                System.out.print("Enter number of rows: ");
                int rows = scanner.nextInt();
                while (rows <= 0 || rows > 10) {
                    System.out.print("Number of rows must be between 1 and 10\n");
                    System.out.print("Enter number of rows: ");
                    rows = scanner.nextInt();
                }
                System.out.print("Enter number of columns: ");
                int cols = scanner.nextInt();
                while (cols <= 0 || cols > 10) {
                    System.out.print("Number of cols must be between 1 and 10\n");
                    System.out.print("Enter number of cols: ");
                    cols = scanner.nextInt();
                }
                System.out.print("Enter first matrix\n");
                int[][] a = ReadMatrix(rows, cols);
                System.out.print("Enter second matrix\n");
                int[][] b = ReadMatrix(rows, cols);

                Matrix A = new Matrix(rows, cols, a);
                Matrix B = new Matrix(rows, cols, b);

                Matrix C = A.add(B);

                System.out.print("The sum of these matrices is: \n");
                printMatrix(C);
                System.out.println();

                //choice to take the difference of two matrices
            } else if (option == 3) {
                System.out.print("Enter number of rows: ");
                int rows = scanner.nextInt();
                while (rows <= 0 || rows > 10) {
                    System.out.print("Number of rows must be between 1 and 10\n");
                    System.out.print("Enter number of rows: ");
                    rows = scanner.nextInt();
                }
                System.out.print("Enter number of columns: ");
                int cols = scanner.nextInt();
                while (cols <= 0 || cols > 10) {
                    System.out.print("Number of cols must be between 1 and 10\n");
                    System.out.print("Enter number of cols: ");
                    cols = scanner.nextInt();
                }
                System.out.print("Enter first matrix to be subtracted from:\n");
                int[][] a = ReadMatrix(rows, cols);
                System.out.print("Enter second matrix to subtract\n");
                int[][] b = ReadMatrix(rows, cols);

                Matrix A = new Matrix(rows, cols, a);
                Matrix B = new Matrix(rows, cols, b);

                Matrix C = A.subtract(B);

                System.out.print("The difference of these matrices is: \n");
                printMatrix(C);
                System.out.println();

            } else {
                System.exit(1);
            }
        }while(option != 4);

    }

    /**
     * ...
     * This method simply prints a menu to the screen for the user to choose from.
     * There are no pre or post conditions.
     * There is no return.
     */

    private static void printMenu()
    {
        System.out.println("1. Get the Transpose of a Matrix");
        System.out.println("2. Add two matrices");
        System.out.println("3. Find the difference of two matrices");
        System.out.println("4. Quit");
    }

    /**
     *
     * @param rows - number of rows in array, given by user before entry into method
     * @param cols - number of columns in array, given by user before entry into method
     * @return the filled in array with user-given values.
     * @pre - see invariants
     * @post
     * The matrix needs to be completely filled.
     * This function takes in user input to fill a 2d array with the matrix numbers
     */

    public static int [][] ReadMatrix(int rows, int cols)
    {
        int[][] values = new int[rows][cols];
        Scanner s = new Scanner(System.in);
        for(int i=0; i < rows ; i++){
            for(int j=0; j < cols ; j++){
                System.out.print("Enter the value for row " + (i+1));
                System.out.print(" column " + (j+1));
                System.out.println();
                values[i][j] = s.nextInt();
            }
        }
        return values;

    }

    /**
     *
     * @param finalMatrix - takes in a matrix that has been transposed, added, or subtracted
     * No return for this method
     * @pre
     * The matrix can't be empty or there will be nothing to print.
     * @post
     * The entire matrix will be printed to the screen.
     * This function just takes in a 2d array, and then prints out all the values.
     */

    public static void printMatrix(Matrix finalMatrix){
        for(int i=0; i < finalMatrix.getRows();i++){
            for(int j=0; j < finalMatrix.getCols(); j++){
                System.out.print(finalMatrix.values[i][j] + "|");
            }
            System.out.println();
        }
    }
}
