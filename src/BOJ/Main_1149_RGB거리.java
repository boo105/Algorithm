package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1149_RGB거리 {
    static int n;
    static int[][] colorCosts;
    static int[][] cache;
    // cache current뿐만 아니라 고르는 색상도 영향있음!!!

    private static int getCost(int current, int preColor, int sum) {
        if(current == n)
            return colorCosts[current - 1][preColor];

        if(preColor != -1 && cache[current][preColor] != 0)
            return cache[current][preColor];

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++) {
            if(preColor != i)
                min = Math.min(min, getCost(current + 1, i , colorCosts[current][i]));
        }

        if(preColor != -1)
            cache[current][preColor] = sum + min;

        return sum + min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        cache = new int[n][3];
        // 빨강, 초록, 파랑
        // 현재집은 이전집과 다음집 색이 같으면 안됨.
        // 집 칠하는 최소비용 구하기
        colorCosts = new int[n][3];

        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");

            for(int j = 0; j < 3; j++) {
                colorCosts[i][j] = Integer.parseInt(input[j]);
            }
        }

        int result = getCost(0, -1, 0);
        System.out.println(result);
    }
}
