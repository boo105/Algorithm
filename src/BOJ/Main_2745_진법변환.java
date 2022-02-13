package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2745_진법변환 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        String n = input[0];
        int b = Integer.parseInt(input[1]);

        long result = 0;
        for(char c : n.toCharArray()) {
            if(c >= 'A' && c <= 'Z')
                result = result * b + ((c - 'A') + 10);
            else
                result = result * b + (c - '0');
        }

        System.out.println(result);
    }
}
