package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_17087_숨바꼭질6 {
    private static long getGCD(long a, long b) {
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }

        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);

        String[] locations = br.readLine().split(" ");

        long result = 0;
        long[] distances = new long[n];
        for(int i = 0; i < n; i++) {
            long locationPosition = Long.parseLong(locations[i]);
            distances[i] = Math.abs(s - locationPosition);
        }

        for(long distance : distances) {
            if(result == 0)
                result = distance;
            else
                result = getGCD(result, distance);
        }

        System.out.println(result);
    }
}
