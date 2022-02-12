package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1373_2진수8진수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();

        int count = 0;
        Stack<Integer> octal = new Stack<>();
        int transfer = 0;
        for(int i = input.length() -1; i >= 0; i--) {
            if(count == 3) {
                octal.push(transfer);
                count = 0;
                transfer = 0;
            }

            if(input.charAt(i) == '1')
                transfer += Math.pow(2, count);

            count++;
        }

        octal.push(transfer);

        while (!octal.isEmpty()) {
            sb.append(octal.pop());
        }
        System.out.println(sb);
    }
}
