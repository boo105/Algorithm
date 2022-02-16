package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1789_수들의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        long sum = 0;
        long count = 0;
        long i = 1;
        while (true) {
            if(sum > n)
                break;

            sum += i;
            count++;
            i++;
        }

        System.out.println(count - 1);
    }
}
