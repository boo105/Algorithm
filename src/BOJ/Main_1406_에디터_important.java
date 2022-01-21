package BOJ;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_1406_에디터_important {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] input = br.readLine().toCharArray();
        int n = Integer.parseInt(br.readLine());

        String[] commands = new String[n];
        for(int i = 0; i < n;  i++)
            commands[i] = br.readLine();

        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        for(char c : input)
            leftStack.push(c);

        for(String command : commands) {
            StringTokenizer st = new StringTokenizer(command, " ", false);

            while (st.hasMoreTokens()) {
                command = st.nextToken();
                switch (command) {
                    case "L" :
                        if(!leftStack.isEmpty()) {
                            char c = leftStack.pop();
                            rightStack.push(c);
                        }
                        break;
                    case "D" :
                        if(!rightStack.isEmpty()) {
                            char c = rightStack.pop();
                            leftStack.push(c);
                        }
                        break;
                    case "B" :
                        if(!leftStack.isEmpty()) {
                            leftStack.pop();
                        }
                        break;
                    case "P" :
                        char c = st.nextToken().charAt(0);
                        leftStack.push(c);
                        break;
                }
            }
        }

        while (!leftStack.isEmpty())
            rightStack.push(leftStack.pop());

        while (!rightStack.isEmpty())
            bw.write(rightStack.pop());

        bw.flush();
        bw.close();
    }
}
