package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10866_덱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] commands = new String[n];
        int[] deck = new int[200001];

        for(int i = 0; i < n; i++)
            commands[i] = br.readLine();

        int front = 10000;
        int back = 10000;
        int size = 0;

        for(String command : commands) {

            StringTokenizer st = new StringTokenizer(command, " ", false);
            while (st.hasMoreTokens()) {
                command = st.nextToken();
                switch (command) {
                    case "push_front" :
                        deck[front] = Integer.parseInt(st.nextToken());
                        front--;
                        size++;
                        break;
                    case "push_back" :
                        back++;
                        deck[back] = Integer.parseInt(st.nextToken());
                        size++;
                        break;
                    case "pop_front" :
                        if(size == 0) {
                            System.out.println(-1);
                        }
                        else {
                            System.out.println(deck[front + 1]);
                            deck[front + 1] = 0;
                            front++;
                            size--;
                        }
                        break;
                    case "pop_back" :
                        if(size == 0) {
                            System.out.println(-1);
                        }
                        else {
                            System.out.println(deck[back]);
                            deck[back] = 0;
                            back--;
                            size--;
                        }
                        break;
                    case "size" :
                        System.out.println(size);
                        break;
                    case "empty" :
                        if(size == 0)
                            System.out.println(1);
                        else
                            System.out.println(0);
                        break;
                    case "front" :
                        if(size == 0)
                            System.out.println(-1);
                        else
                            System.out.println(deck[front + 1]);
                        break;
                    case "back" :
                        if(size == 0)
                            System.out.println(-1);
                        else
                            System.out.println(deck[back]);
                        break;
                }
            }

        }

    }
}
