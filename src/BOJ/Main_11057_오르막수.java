package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11057_오르막수 {
    static int n;
    static int[][] cache;
    private static int getCount(int current, int preNumber) {
        if(current == n)
            return 1;

        int ret = cache[current][preNumber];
        if(ret != 0)
            return ret;

        int sum = 0;

        for(int i = 0; i <= 9; i++) {
            if(preNumber <= i)
                sum += getCount(current + 1, i);
        }

        cache[current][preNumber] = sum % 10007;
        return sum % 10007;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        cache = new int[n][10];

        System.out.println(getCount(0, 0));
    }
}
