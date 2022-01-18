package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_9012_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean isVPS = true;

            for(char c : input.toCharArray()) {
                if(c == '('){
                    stack.push(')');
                }
                else {
                    if(!stack.isEmpty())
                        stack.pop();
                    else {
                        isVPS = false;
                        break;
                    }
                }
            }

            if(!stack.isEmpty())
                isVPS = false;

            if(isVPS)
                result.append("YES\n");
            else
                result.append("NO\n");
        }

        System.out.println(result);
    }
}
