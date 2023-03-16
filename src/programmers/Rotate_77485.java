package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Rotate_77485 {
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int rows = Integer.parseInt(br.readLine());
        int columns = Integer.parseInt(br.readLine());

        map = new int[rows][columns];
        int[][] queries = {
                {2,2,5,4},
                {3,3,6,6},
                {5,1,6,3}
        };
        int[] result = new int[queries.length];

        init();
        for(int i = 0; i < queries.length; i++) {
            result[i] = rotateMap(queries[i]);
        }

        System.out.println(result);
    }

    private static int rotateMap(final int[] query) {
        int startX = query[1] - 1, startY = query[0] - 1;
        int endX = query[3] - 1, endY = query[2] - 1;

        int min = Integer.MAX_VALUE;
        int tempStorage = -1;

        for(int i = startX; i < endX; i++) {
            if(tempStorage != -1){
                if(min > tempStorage)
                    min = tempStorage;

                int temp = map[startY][i + 1];
                map[startY][i + 1] = tempStorage;
                tempStorage = temp;
            }
            else {
                if(min > map[startY][i])
                    min = map[startY][i];

                tempStorage = map[startY][i + 1];
                map[startY][i + 1] = map[startY][i];
            }
        }

        // 두번째 단계 이상 부터는 무조건 tempStorage가 있음
        for(int i = startY; i < endY; i++) {
            if(min > tempStorage)
                min = tempStorage;

            int temp = map[i + 1][endX];
            map[i + 1][endX] = tempStorage;
            tempStorage = temp;
        }

        for(int i = endX; i > startX; i--) {
            if(min > tempStorage)
                min = tempStorage;

            int temp = map[endY][i - 1];
            map[endY][i - 1] = tempStorage;
            tempStorage = temp;
        }

        for(int i = endY; i > startY; i--) {
            if(min > tempStorage)
                min = tempStorage;

            int temp = map[i - 1][startX];
            map[i - 1][startX] = tempStorage;
            tempStorage = temp;
        }

        return min;
    }

    private static void init() {
        int count = 1;
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                map[i][j] = count;
                count++;
            }
        }
    }
}
