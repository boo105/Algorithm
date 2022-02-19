package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2669_직사각형네개의합집합의면적구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] positions = new int[4][4];
        for(int i = 0; i < 4; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < input.length; j++) {
                positions[i][j] = Integer.parseInt(input[j]);
            }
        }

        boolean[][] isValue = new boolean[101][101];
        for(int i = 0; i < 4; i++) {
            for(int currentY = positions[i][1]; currentY < positions[i][3]; currentY++) {
                for(int currentX = positions[i][0]; currentX < positions[i][2]; currentX++) {
                    if(!isValue[currentX][currentY])
                        isValue[currentX][currentY] = true;
                }
            }
        }

        int count = 0;
        for(int i = 0; i < isValue.length; i++) {
            for(int j = 0; j < isValue[0].length; j++) {
                if(isValue[i][j])
                    count++;
            }
        }
        System.out.println(count);
    }
}
