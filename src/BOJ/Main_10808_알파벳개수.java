package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10808_알파벳개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();

        int[] alpha = new int[26];

        for(char c : input.toCharArray()) {
            alpha[c - 'a'] += 1;
        }

        for(int i = 0; i < alpha.length; i++)
            sb.append(alpha[i] + " ");

        System.out.println(sb);
    }
}
