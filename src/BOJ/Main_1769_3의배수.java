package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1769_3의배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int count = 1;
        int result = 0;
        while (input.length() != 1) {
            for(char c : input.toCharArray()) {
                int num = Character.getNumericValue(c);
                result += num;
            }

            if((result / 10) == 0)
                break;

            input = Integer.toString(result);
            result = 0;
            count++;
        }

        if(count == 1) {
            count = 0;
            result = Integer.parseInt(input);
        }

        System.out.println(count);
        String isThridNum = (result % 3) == 0 ? "YES" : "NO";
        System.out.println(isThridNum);
    }
}
