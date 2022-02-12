package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1212_8진수2진수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();

        for(int i = 0; i < input.length(); i++) {
            String num = Integer.toBinaryString(input.charAt(i) - '0');

            if(i != 0) {
                if(num.length() == 2)
                    num = "0" + num;
                else if(num.length() == 1)
                    num = "00" + num;
            }
            sb.append(num);
        }

        System.out.println(sb);
    }
}
