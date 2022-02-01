package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1929_소수구하기_Important {
    private static boolean[] prime;

    /* 에라토스테네스의 체 방식
    * 2부터 자기 자신을 제외한 배수가 되는 것을 지우면 됨.
    * */
    private static void getPrime() {
        prime[0] = prime[1] = true;

        for(int i = 2; i <= Math.sqrt(prime.length); i++) {
            if(!prime[i]) {
                for(int j = i * i; j < prime.length; j += i)
                    prime[j] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        prime = new boolean[N + 1];
        getPrime();

        for(int i = M; i <= N; i++) {
            // false 소수
            if(!prime[i])
                sb.append(i + "\n");
        }

        System.out.println(sb);
    }
}
