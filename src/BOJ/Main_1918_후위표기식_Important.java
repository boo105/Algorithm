package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1918_후위표기식_Important {
    private static int precedence(char op) {
        if(op == '*' || op == '/')
            return 2;
        else if(op == '+' || op == '-')
            return 1;
        else
            return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        Stack<Character> expressionStack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(char c : input.toCharArray()) {
            switch (c) {
                case '+' :
                case '-' :
                case '*' :
                case '/' :
                    while (!expressionStack.isEmpty() && precedence(expressionStack.peek()) >= precedence(c)) {
                        sb.append(expressionStack.pop());
                    }
                    expressionStack.push(c);
                    break;
                case '(' :
                    expressionStack.push(c);
                    break;
                case ')' :
                    while (!expressionStack.isEmpty() && expressionStack.peek() != '(') {
                        sb.append(expressionStack.pop());
                    }
                    expressionStack.pop();
                    break;
                default:
                    sb.append(c);
            }
        }

        while (!expressionStack.isEmpty()) {
            sb.append(expressionStack.pop());
        }
        System.out.println(sb);
    }
}
