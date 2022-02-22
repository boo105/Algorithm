package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11727_2xn타일링2 {
    static int[] cache;
    static final int MOD = 10007;

    private static int tilling(int width) {
        if(width <= 1)
            return 1;

        int ret = cache[width];

        if(ret != 0)
            return ret;

        ret = (tilling(width - 1) + tilling(width - 2) + tilling(width - 2)) % MOD;
        cache[width] = ret;
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        cache = new int[1001];

        int result = tilling(n);

        System.out.println(result);
    }
}
