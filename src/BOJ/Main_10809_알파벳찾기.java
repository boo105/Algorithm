package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_10809_알파벳찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();

        int[] alpha = new int[26];
        Arrays.fill(alpha, -1);

        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(alpha[c - 'a'] == -1)
                alpha[c - 'a'] = i;
        }

        for(int i = 0; i < alpha.length; i++)
            sb.append(alpha[i] + " ");

        System.out.println(sb);
    }
}
