package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Keyboard_160586 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] keymap = br.readLine().split(" ");
        String[] targets = br.readLine().split(" ");

        int[] answer = new int[targets.length];
        for(int i = 0; i < targets.length; i++) {
            int result = getMinInputCount(keymap, targets[i]);
            answer[i] = result;
        }

        for(int i = 0; i < answer.length; i++) {
            sb.append(answer[i]);
            if(i != answer.length - 1)
                sb.append(", ");
        }

        System.out.println(sb);
    }

    private static int getMinInputCount(String[] keymap , String target) {
        int result = 0;

        for(int i = 0; i < target.length(); i++) {
            char inputChar = target.charAt(i);

            int min = Integer.MAX_VALUE;
            for(String keyboard : keymap) {
                int count = keyboard.indexOf(inputChar) + 1;
                if(count != 0 && min > count) {
                    min = count;
                }
            }

            if(min == Integer.MAX_VALUE)
                return -1;
            result += min;
        }

        return result;
    }
}
