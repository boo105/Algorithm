package BOJ;

import java.io.*;
import java.util.Stack;

public class Main_10799_쇠막대기_Important {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        Stack<Character> stack = new Stack<>();
        int result = 0;

        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '(')
                stack.push('(');
            else {
                // 레이저
                if(input.charAt(i - 1) == '(') {
                    stack.pop();
                    result += stack.size();
                }
                else {  // 쇠막대기
                    stack.pop();
                    result += 1;
                }
            }
        }

        System.out.println(result);
    }
}
