package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11005_진법변환2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");

        long n = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        while (n > 0) {
            char result = (char) (n % b);
            if(result < 10) {
                sb.append((char) (result + '0'));
            }
            else {
                sb.append((char)(result - 10 + 'A'));   // 아스키 코드 값 넣어줌
            }
            n /= b;
        }

        System.out.println(sb.reverse());


    }
}
