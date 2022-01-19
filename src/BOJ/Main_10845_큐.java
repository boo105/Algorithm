package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10845_큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] commands = new String[n];
        int[] queue = new int[n];
        int front = 0;
        int back = 0;

        for(int i = 0; i < n; i++)
            commands[i] = br.readLine();

        for(String command : commands) {
            StringTokenizer st = new StringTokenizer(command, " ", false);

            while (st.hasMoreTokens()) {
                String token = st.nextToken();

                switch (token) {
                    case "push" :
                        int num = Integer.parseInt(st.nextToken());
                        queue[back] = num;
                        back++;
                        if(back >= n)
                            back = 0;
                        break;
                    case "pop" :
                        if(front == back)
                            System.out.println(-1);
                        else {
                            System.out.println(queue[front]);
                            queue[front] = 0;
                            front++;
                            if(front >= n)
                                front = 0;
                        }
                        break;
                    case "size" :
                        System.out.println(Math.abs(back - front));
                        break;
                    case "empty" :
                        if(front == back)
                            System.out.println(1);
                        else
                            System.out.println(0);
                        break;
                    case "front" :
                        if(front == back)
                            System.out.println(-1);
                        else
                            System.out.println(queue[front]);
                        break;
                    case "back" :
                        if(front == back)
                            System.out.println(-1);
                        else
                            System.out.println(queue[back - 1]);
                        break;
                }
            }
        }
    }
}
