package Arrays;

import java.util.Arrays;

/**
 * <p>
 *    problem: Given a matrix, your task is to rotate the matrix 90 degrees clockwise.
 * </p>
 * <pre>
 *     Example:
 *        Input: [[1,2,3],[4,5,6],[7,8,9]]
 *
 *        Output: [[7,4,1],[8,5,2],[9,6,3]]
 *
 *     Explanation: Rotate the matrix simply by 90 degree clockwise and return the matrix.
 * </pre>
 */
public class RotateMatrix {
    public static void main (String[] args) {
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        matrix = rotateMatrixNintyDegreeOptimized (matrix);
        for(int[] row : matrix) {
            for(int col : row) {
                System.out.print (col+" ");
            }
            System.out.println ();
        }
    }
    public static int[][] rotateMatrixNintyDegree(int[][] matrix) {
        int[][] rotateMatrix = new int[matrix.length][matrix.length];
        int row = matrix.length - 1;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                rotateMatrix[j][row] = matrix[i][j];
            }
            row--;
        }
        return  rotateMatrix;
    }

    public static int[][] rotateMatrixNintyDegreeOptimized(int[][] matrix) {
        for(int i=0; i<= matrix.length; i++) {
            // transpose of the matrix
            for(int j=i; j < matrix.length; j++) {
                if(i != j) {
                    int temp = matrix[ i ][ j ];
                    matrix[ i ][ j ] = matrix[ j ][ i ];
                    matrix[ j ][ i ] = temp;
                }
            }
        }
      //reverse the transpose
      for(int i = 0; i < matrix.length; i++) {
             reverse (matrix[i],0,matrix.length-1);
        }

        return matrix;
    }

    public static void reverse(int[] arr, int start, int end) {
        if(start >= end) {
            return;
        }
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        reverse (arr, start+1, end-1);
    }
}
