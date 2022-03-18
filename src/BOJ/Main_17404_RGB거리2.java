package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_17404_RGB거리2 {
    static int n;
    static int[][][] cache;
    static int[][] costs;

    private static int getCost(int currentIndex, int preColor, int firstColor) {
        if(currentIndex == n)
            return costs[currentIndex - 1][preColor];

        if(preColor != -1) {
            int ret = cache[currentIndex][preColor][firstColor];
            if(ret != 0)
                return ret;
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++) {
            if(preColor == i)
                continue;
            if(currentIndex == n - 1 && firstColor == i)
                continue;

            if(currentIndex == 0)
                min = Math.min(min, getCost(currentIndex + 1, i, i));
            else
                min = Math.min(min, getCost(currentIndex + 1, i, firstColor));
        }

        if(preColor != -1) {
            int sum = min + costs[currentIndex - 1][preColor];
            cache[currentIndex][preColor][firstColor] = sum ;
            return sum;
        }
        else
            return min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        costs = new int[n][3];
        cache = new int[n][3][3];

        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < input.length; j++) {
                costs[i][j] = Integer.parseInt(input[j]);
            }
        }

        int answer = getCost(0, -1, -1);
        System.out.println(answer);

    }
}

