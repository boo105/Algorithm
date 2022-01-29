package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11655_ROT13 {
    public static void main(String[] args) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();

        for(char c : input.toCharArray()) {
            if(Character.isAlphabetic(c)) {
                if(Character.isLowerCase(c)) {
                    c += 13;
                    if(c > 'z')
                        c += 'a' - 'z' - 1;
                }
                else {
                    c += 13;
                    if(c > 'Z')
                        c += 'A' - 'Z' - 1;
                }
                sb.append(c);
            }
            else
                sb.append(c);
        }

        System.out.println(sb);
    }
}
