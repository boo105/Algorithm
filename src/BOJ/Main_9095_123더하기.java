package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9095_123더하기 {
    static int[] cache;
    private static int getCount(int num, int sum) {
        if(sum > num)
            return 0;
        else if(sum == num)
            return 1;

        int ret = cache[sum];
        if(ret != 0)
            return ret;

        ret = getCount(num, sum + 1) + getCount(num, sum + 2) + getCount(num, sum + 3);
        cache[sum] = ret;
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t =  Integer.parseInt(br.readLine());


        for(int i = 0; i < t; i++) {
            int num = Integer.parseInt(br.readLine());
            cache = new int[num];
            int result = getCount(num, 0);
            sb.append(result + "\n");
        }

        System.out.println(sb);
    }
}
