package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11722_가장긴감소하는부분수열 {
    static int[] score;
    static int n;
    static int[] cache;

    private static int getMaxDescreaseSequence(int preIndex, int currentIndex) {
        if(currentIndex == n)
            return 0;

        if(preIndex != -1 && (score[preIndex] <= score[currentIndex]) )
            return 0;

        int ret = cache[currentIndex];
        if(ret != 0)
            return ret;

        int max = 0;
        for(int i = currentIndex + 1; i < n; i++) {
            max = Math.max(max, getMaxDescreaseSequence(currentIndex, i));
        }

        int distance = max + 1;
        cache[currentIndex] = distance;
        return distance;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        score = new int[n];
        cache = new int[n];

        for(int i = 0; i < n; i++)
            score[i] = Integer.parseInt(input[i]);

        int result = 0;
        for(int i = 0; i < n; i++) {
            result = Math.max(result, getMaxDescreaseSequence(-1, i));
        }
        System.out.println(result);
    }
}
