package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9465_스티커_Important {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] stickerScore = new int[2][n + 1];
            int[][] dp = new int[2][n + 1];

            for(int j = 0; j < 2; j++) {
                String[] input = br.readLine().split(" ");
                for(int k = 1; k <= n; k++)
                    stickerScore[j][k] = Integer.parseInt(input[k - 1]);
            }

            dp[0][1] = stickerScore[0][1];
            dp[1][1] = stickerScore[1][1];

            for(int index = 2; index <= n; index++) {
                dp[0][index] = Math.max(dp[1][index - 1], dp[1][index - 2]) + stickerScore[0][index];
                dp[1][index] = Math.max(dp[0][index - 1], dp[0][index - 2]) + stickerScore[1][index];
            }
            sb.append(Math.max(dp[0][n], dp[1][n]) + "\n");
        }

        System.out.println(sb);
    }
}
