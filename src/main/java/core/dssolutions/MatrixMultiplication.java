package core.dssolutions;

import java.util.Scanner;

public class MatrixMultiplication {

  public static void readMatrix(int[][] mat, int matrix_size) {

    Scanner scanner = new Scanner(System.in);

    for (int i = 0; i < matrix_size; i++) {
      for (int j = 0; j < matrix_size; j++) {
        mat[i][j] = scanner.nextInt();
        scanner.nextLine();
      }
    }
  }

  public static void main(String[] args) {

    final int matrix_size = 3;
    int[][] matrixA = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
    int[][] matrixB = new int[][]{{1,2,3},{4,5,6},{7,8,9}};

    int [][] result = new int[3][3];

    // read the matrixA:
                     
//    readMatrix(matrixA, matrix_size);
//    readMatrix(matrixB, matrix_size);
//

    // Doing A X B

    for (int i = 0; i < matrix_size; i++) {
      for (int j = 0; j < matrix_size; j++) {
        for(int k=0; k<matrix_size;k++){
            result[i][j] += matrixA[i][k]*matrixB[k][j];
        }
      }
    }


    for (int i = 0; i < matrix_size; i++) {
      for (int j = 0; j < matrix_size; j++) {
        System.out.print(result[i][j] + " ");
      }
      System.out.println();
             }
 }    // main ends
    


}
