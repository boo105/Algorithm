package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_14500_테트로미노 {
    static boolean[][] visited;
    static int[] matrixSize = new int[2];
    static int[][] scoreMatrix;
    static int max;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};


    private static void dfs(int x, int y, int depth, int sum) {
        if(depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for(int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX < 0 || nextY < 0 || nextX >= matrixSize[1] || nextY >= matrixSize[0]) {
                continue;
            }
            if(visited[nextY][nextX]) {
                continue;
            }
            visited[nextY][nextX] = true;
            dfs(nextX, nextY, depth + 1, sum + scoreMatrix[nextY][nextX]);
            visited[nextY][nextX] = false;
        }
    }

    // ㅗ ㅜ ㅏ ㅓ 형태 처리
    private static void check(int x, int y) {
        int N = matrixSize[0];
        int M = matrixSize[1];

        if(y < N - 2 && x < M -1)
            max = Math.max(max, scoreMatrix[y][x] + scoreMatrix[y + 1][x] + scoreMatrix[y + 2][x] + scoreMatrix[y + 1][x + 1]);

        if (y < N - 2 && x > 0)
            max = Math.max(max, scoreMatrix[y][x] + scoreMatrix[y + 1][x] + scoreMatrix[y + 2][x] + scoreMatrix[y + 1][x - 1]);

        if (y < N - 1 && x < M - 2)
            max = Math.max(max, scoreMatrix[y][x] + scoreMatrix[y][x + 1] + scoreMatrix[y][x + 2] + scoreMatrix[y + 1][x + 1]);

        if (y > 0 && x < M - 2)
            max = Math.max(max, scoreMatrix[y][x] + scoreMatrix[y][x + 1] + scoreMatrix[y][x + 2] + scoreMatrix[y - 1][x + 1]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] matrixSizeStr = br.readLine().split(" ");
        for(int i = 0; i < 2; i++) {
            matrixSize[i] = Integer.parseInt(matrixSizeStr[i]);
        }
        scoreMatrix = new int[matrixSize[0]][matrixSize[1]];
        visited = new boolean[matrixSize[0]][matrixSize[1]];

        for(int i = 0; i < matrixSize[0]; i++) {
           String[] scoreStr = br.readLine().split(" ");
           for(int j = 0; j < scoreStr.length; j++) {
               scoreMatrix[i][j] = Integer.parseInt(scoreStr[j]);
           }
        }

        for(int i = 0; i < matrixSize[0]; i++) {
            for(int j = 0; j < matrixSize[1]; j++) {
                visited[i][j] = true;
                dfs(j, i, 1, scoreMatrix[i][j]);
                visited[i][j] = false;
                check(j, i);
            }
        }

        System.out.println(max);
    }
}
