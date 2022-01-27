package BOJ;

import java.io.*;
import java.util.Stack;

public class Main_17298_오큰수_Important {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        Stack<Integer> result = new Stack<>();
        Stack<Integer> stack = new Stack<>();

        for(int i = n-1; i >= 0; i--) {
            int num = Integer.parseInt(arr[i]);
            while(!stack.isEmpty() && stack.peek() <= num) {
                stack.pop();
            }

            if(stack.isEmpty())
                result.push(-1);
            else
                result.push(stack.peek());

            stack.push(num);
        }

        while (!result.isEmpty())
            bw.write(result.pop() + " ");
        bw.flush();
        bw.close();
    }
}
