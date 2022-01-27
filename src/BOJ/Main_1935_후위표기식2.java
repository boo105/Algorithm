package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1935_후위표기식2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        double[] values = new double[n];

        String expression = br.readLine();
        for(int i = 0; i < n; i++) {
            values[i] = Double.parseDouble(br.readLine());
        }

        Stack<Double> stack = new Stack<>();
        for(int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if(c >= 'A' && c <= 'Z') {
                stack.push(values[c - 'A']);
            }
            else {
                double num1 = stack.pop();
                double num2 = stack.pop();
                // 이거 근데 백준에서는 switch 최신스타일 지원안함.....
                double result = switch (c) {
                    case '*' -> num2 * num1;
                    case '/' -> num2 / num1;
                    case '+' -> num2 + num1;
                    case '-' -> num2 - num1;
                    default -> 0;
                };
                stack.push(result);
            }
        }

        System.out.println(String.format("%.2f",stack.pop()));
    }
}
