package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_16935_배열돌리기3 {
    static int n;
    static int m;

    private static int[][] changeUpDown(int[][] matrix) {
        int[][] newMatrix = new int[matrix.length][matrix[0].length];

        for(int i = matrix.length - 1; i >= 0; i--) {

            for(int j = 0; j < matrix[0].length; j++) {
                newMatrix[(matrix.length - 1) - i][j] = matrix[i][j];
            }
        }

        return newMatrix;
    }

    private static int[][] changeLeftRight(int[][] matrix) {
        int[][] newMatrix = new int[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++) {

            for(int j = matrix[0].length - 1; j >= 0; j--) {
                newMatrix[i][(matrix[0].length - 1) - j] = matrix[i][j];
            }
        }

        return newMatrix;
    }

    private static int[][] changeRightRotation(int[][] matrix) {
        int[][] newMatrix = new int[matrix[0].length][matrix.length];

        for(int i = 0; i < matrix[0].length; i++) {
            for(int j = matrix.length - 1; j >= 0; j--) {
                newMatrix[i][(matrix.length - 1) - j] = matrix[j][i];
            }
        }

        return newMatrix;
    }

    private static int[][] changeLeftRotation(int[][] matrix) {
        int[][] newMatrix = new int[matrix[0].length][matrix.length];

        for(int i = matrix[0].length - 1; i >= 0; i--) {
            for(int j = 0; j < matrix.length; j++) {
                newMatrix[(matrix[0].length - 1) - i][j] = matrix[j][i];
            }
        }

        return newMatrix;
    }

    private static int[][] changeGroupFirst(int[][] matrix) {
        int[][] newMatrix = new int[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length / 2; j++) {
                if(i >= matrix.length / 2) {  // 4 -> 1
                    newMatrix[i - (matrix.length / 2)][j] = matrix[i][j];
                }
                else {  // 1 -> 2
                    newMatrix[i][j + (matrix[0].length / 2)] = matrix[i][j];
                }
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            for(int j = matrix[0].length / 2; j < matrix[0].length; j++) {
                if(i >= matrix.length / 2) {  // 3 -> 4
                    newMatrix[i][j - (matrix[0].length / 2)] = matrix[i][j];
                }
                else {  // 2 -> 3
                    newMatrix[i + (matrix.length / 2)][j] = matrix[i][j];
                }
            }
        }

        return newMatrix;
    }

    private static int[][] changeGroupSecond(int[][] matrix) {
        int[][] newMatrix = new int[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length / 2; j++) {
                if(i >= matrix.length / 2) {  // 4 -> 3
                    newMatrix[i][j + (matrix[0].length / 2)] = matrix[i][j];
                }
                else {  // 1 -> 4
                    newMatrix[i + (matrix.length / 2)][j] = matrix[i][j];
                }
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            for(int j = matrix[0].length / 2; j < matrix[0].length; j++) {
                if(i >= matrix.length/2) {  // 3 -> 2
                    newMatrix[i - (matrix.length / 2)][j] = matrix[i][j];
                }
                else {  // 2 -> 1
                    newMatrix[i][j - (matrix[0].length / 2)] = matrix[i][j];
                }
            }
        }

        return newMatrix;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        int[][] matrix = new int[n][m];

        for(int i = 0; i < n; i++) {
            String[] matrixStr = br.readLine().split(" ");

            for(int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(matrixStr[j]);
            }
        }
        String[] options = br.readLine().split(" ");

        for(String option : options) {
            switch (option) {
                case "1" :
                    matrix = changeUpDown(matrix);
                    break;
                case "2" :
                    matrix = changeLeftRight(matrix);
                    break;
                case "3" :
                    matrix = changeRightRotation(matrix);
                    break;
                case "4" :
                    matrix = changeLeftRotation(matrix);
                    break;
                case "5" :
                    matrix = changeGroupFirst(matrix);
                    break;
                case "6" :
                    matrix = changeGroupSecond(matrix);
                    break;
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                sb.append(matrix[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
