package Arrays;

/**
 * <p>
 * problem: Given a matrix if an element in the matrix is 0 then you will have to set its entire column and row to 0 and then return the matrix.
 * <p>
 * <pre>
 * Example:
 *   Input: matrix=[[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 *   Output:[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *
 * Explanation: Since matrix[0][0]=0 and matrix[0][3]=0. Therefore 1st row, 1st column and 4th column will be set to 0
 * </pre>
 */
public class SetMatrixZeros {
    public static void main (String[] args) {
        int[][] matrix = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
        int[][] matrix1 = { { 0, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        setMatrixZeroesOptimised (matrix1);
        for (int[] row : matrix1) {
            for (int col : row) {
                System.out.print (col + " ");
            }
            System.out.println ();
        }
    }

    // This is brute force approach
    public static void setMatrixZeros (int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[ i ].length; j++) {
                int tempRow = 0;
                int tempCol = 0;
                if (matrix[ i ][ j ] == 0) {
                    while (tempRow < matrix.length) {
                        if (matrix[ tempRow ][ j ] != 0)
                            matrix[ tempRow ][ j ] = - 1;
                        tempRow++;
                    }
                    while (tempCol < matrix[ i ].length) {
                        if (matrix[ i ][ tempCol ] != 0)
                            matrix[ i ][ tempCol ] = - 1;
                        tempCol++;
                    }

                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[ i ].length; j++) {
                if (matrix[ i ][ j ] == - 1) {
                    matrix[ i ][ j ] = 0;
                }
            }
        }
    }

    //Trying better approach with extra space
    public static void setZeroesMatrixOptimalWithExtraSpace (int[][] matrix) {
        int[] markZeroRow = new int[ matrix.length ];
        int[] markZeroCol = new int[ matrix[ 0 ].length ];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[ i ].length; j++) {
                //if 0 found on ith row and jth column
                if (matrix[ i ][ j ] == 0) {
                    //mark the whole row, that needs to be converted into 0
                    markZeroRow[ i ] = 1;
                    //mark the whole column, that needs to be converted into 0
                    markZeroCol[ j ] = 1;
                }
            }
        }
        //now initialize the rows and columns with 0, those have been marked
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[ i ].length; j++) {
                if (markZeroRow[ i ] == 1 || markZeroCol[ j ] == 1) {
                    matrix[ i ][ j ] = 0;
                }
            }
        }
    }
    //This is the optimized approach with using extra space
    public static void setMatrixZeroesOptimised(int[][] matrix) {
       int colZero = 1;
        // Step 1: Use first row and first column as markers
        for(int i=0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    if(j != 0) {
                        matrix[0][j] = 0;
                    } else {
                        colZero = 0;
                    }
                }
            }
        }
        // Step 2: Set zeroes based on markers
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[i].length; j++) {
                if(matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // Step 3: Handle the first column
        if(matrix[0][0] == 0) {
            for(int i=0; i<matrix.length;i++) {
                matrix[i][0] = 0;
            }
        }
        // Step 4: Handle the first row
        if(colZero == 0) {
            for(int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}
