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
* */
public class SetMatrixZeros {
    public static void main (String[] args) {
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setMatrixZeros (matrix);
        for(int[] row: matrix) {
            for(int col : row) {
                System.out.print (col+" ");
            }
            System.out.println ();
        }
    }
    public static void setMatrixZeros(int[][] matrix) {

        for(int i = 0; i< matrix.length;i++) {
            for(int j=0;j<matrix[i].length;j++) {
                int tempRow = 0;
                int tempCol = 0;
                if(matrix[i][j] == 0) {
                    while(tempRow < matrix.length) {
                        if(matrix[tempRow][j] != 0)
                           matrix[tempRow][j] = -1;
                        tempRow++;
                    }
                    while(tempCol < matrix[i].length) {
                        if(matrix[i][tempCol] != 0)
                           matrix[i][tempCol] = -1;
                        tempCol++;
                    }

                }
            }
        }

        for(int i = 0; i < matrix.length;i++) {
            for(int j = 0; j < matrix[i].length;j++) {
                if(matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
