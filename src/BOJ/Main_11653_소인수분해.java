package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11653_소인수분해 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long input = Long.parseLong(br.readLine());

        for(int i = 2; i <= Math.sqrt(input); i++) {
            while (input % i == 0) {
                sb.append(i + "\n");
                input /= i;
            }
        }

        if(input != 1)
            sb.append(input);
        System.out.println(sb);
    }
}
