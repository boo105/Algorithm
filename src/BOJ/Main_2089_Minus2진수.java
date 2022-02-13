package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2089_Minus2진수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long input = Long.parseLong(br.readLine());

        if(input == 0)
            System.out.println(0);
        else {
            while (input != 1) {
                sb.append(Math.abs(input % -2));

                // 2진수랑 다르게 나머지가 존재하면 올림 해줘야함
                input = (long) Math.ceil( (double) input/ (-2) );
            }

            sb.append(input);
        }

        System.out.println(sb.reverse());
    }
}
