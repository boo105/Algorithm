package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9613_GCD합 {
    private static int getGCD(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }

    private static long getTotalGCD(int start, int prePick, String[] numbers) {
        if(start == numbers.length)
            return 0;

        long result = 0;

        for(int i = start; i < numbers.length; i++) {
            int num = Integer.parseInt(numbers[i]);
            result += getGCD(num, prePick);
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            String[] numbers = br.readLine().split(" ");
            long totalGCD = 0;
            for(int j = 1; j < numbers.length; j++) {
                int num = Integer.parseInt(numbers[j]);
                totalGCD += getTotalGCD(j + 1, num, numbers);
            }
            sb.append(totalGCD + "\n");
        }
        System.out.println(sb);
    }
}
