package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1874_스택수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int[] sequence = new int[n];
        int cursor = 0;

        StringBuilder result = new StringBuilder();

        for(int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(br.readLine());
        }

        // 1 ~ n
        for(int i = 1; i <= n; i++) {
            stack.push(i);
            result.append("+\n");
            while (stack.peek() == sequence[cursor]) {
                stack.pop();
                cursor++;
                result.append("-\n");

                if(stack.isEmpty())
                    break;
            }
        }

        if(cursor != n)
            System.out.println("NO");
        else
            System.out.println(result);
    }
}
