package BOJ;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main_17413_단어뒤집기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        StringBuilder sb = new StringBuilder();
        Stack<Character> reverseStack = new Stack<>();

        boolean isReverse = true;
        for(char c : input.toCharArray()) {
            if(c == '<') {
                while (!reverseStack.isEmpty()) {
                    sb.append(reverseStack.pop());
                }

                isReverse = false;
            }

            if(isReverse) {
                if(c == ' ') {
                    while (!reverseStack.isEmpty()) {
                        sb.append(reverseStack.pop());
                    }
                    sb.append(" ");
                    continue;
                }
                reverseStack.push(c);
            }
            else
                sb.append(c);

            if(c == '>')
                isReverse = true;
        }

        while (!reverseStack.isEmpty()) {
            sb.append(reverseStack.pop());
        }

        System.out.println(sb);
    }
}
