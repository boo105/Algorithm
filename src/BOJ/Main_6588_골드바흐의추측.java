package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_6588_골드바흐의추측 {
    private static boolean[] prime;

    private static void getPrime() {
        prime[0] = prime[1] = true;

        for(int i = 2; i <= Math.sqrt(prime.length); i++) {
            if(!prime[i]) {
                for(int j = i * i; j < prime.length; j += i) {
                    prime[j] = true;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        prime = new boolean[1000001];
        getPrime();

        while (true) {
            String input = br.readLine();
            int n = Integer.parseInt(input);
            if(n == 0)
                break;
            boolean isOK = false;
            for(int i = 3; i <= n; i+=2) {
                if(!prime[i] && !prime[n - i]) {
                    sb.append(n + " = " + i + " + " + (n - i) + "\n");
                    isOK = true;
                    break;
                }
            }
            if(!isOK)
                sb.append("Goldbach's conjecture is wrong.\n");
        }

        System.out.println(sb);
    }
}
