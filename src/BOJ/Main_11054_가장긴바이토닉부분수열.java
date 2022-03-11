package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11054_가장긴바이토닉부분수열 {
    static int n;
    static int[] score;
    static int[][] cache;

    private static int getSequenceDistance(int preIndex, int currentIndex, int detectDirection) {
        if(currentIndex == n)
            return 0;

        int test = score[currentIndex];
        if(preIndex != -1) {
            if(detectDirection == 0) {  // 초기
                if(score[preIndex] < score[currentIndex])  // 오름차순 판정
                    detectDirection = 1;
                else if(score[preIndex] > score[currentIndex]) // 내림차순 판정
                    detectDirection = 2;
                else
                    return 0;
            }
            else if(detectDirection == 1) { // 처음에는 오름차순일 때
                if(score[preIndex] > score[currentIndex])
                    detectDirection = 2;
                else if(score[preIndex] == score[currentIndex])
                    return 0;
            }
            else if(detectDirection == 2) { // 처음부터 내림차순 일때
                if(score[preIndex] <= score[currentIndex])
                    return 0;
            }
        }

        int ret = cache[currentIndex][detectDirection];
        if(ret != 0)
            return ret;

        int max = 0;
        for(int i = currentIndex + 1; i < n; i++) {
            max = Math.max(max, getSequenceDistance(currentIndex, i, detectDirection));
        }

        int distance = max + 1;
        cache[currentIndex][detectDirection] = distance;
        return distance;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        score = new int[n];
        cache = new int[n][3];

        for(int i = 0; i < n; i++)
            score[i] = Integer.parseInt(input[i]);

        int result = 0;
        for(int i = 0; i < n; i++) {
            result = Math.max(result, getSequenceDistance(-1, i, 0));
        }
        System.out.println(result);
    }
}
