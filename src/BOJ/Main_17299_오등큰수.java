package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_17299_오등큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int[] fx = new int[10000001];

        Stack<Integer> result = new Stack<>();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++)
        {
            int num = Integer.parseInt(arr[i]);
            fx[num]++;
        }

        for(int i = n-1; i >= 0; i--) {
            int num = Integer.parseInt(arr[i]);
            while (!stack.isEmpty() && fx[stack.peek()] <= fx[num]) {
                stack.pop();
            }

            if(stack.isEmpty())
                result.push(-1);
            else
                result.push(stack.peek());

            stack.push(num);
        }

        while (!result.isEmpty())
            sb.append(result.pop() + " ");

        System.out.println(sb);
    }


}
