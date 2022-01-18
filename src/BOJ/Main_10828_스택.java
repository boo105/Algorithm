package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_10828_스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<String> commands = new ArrayList<>();

        int[] stack = new int[n];
        int cursor = 0;

        for(int i = 0; i < n; i++) {
            commands.add(br.readLine());
        }

        for(String command : commands) {
            String[] commandSplit  = command.split(" ");
            // push 커맨드
            if(commandSplit.length == 2) {
                stack[cursor] = Integer.parseInt(commandSplit[1]);
                cursor++;
            }
            else {
                command = commandSplit[0];

                switch (command) {
                    case "pop" :
                        if(cursor == 0)
                            System.out.println(-1);
                        else {
                            System.out.println(stack[cursor - 1]);
                            stack[cursor - 1] = 0;
                            cursor--;
                        }
                        break;
                    case "size" :
                        System.out.println(cursor);
                        break;
                    case "empty" :
                        System.out.println(cursor == 0 ? 1 : 0);
                        break;
                    case "top" :
                        if(cursor == 0)
                            System.out.println(-1);
                        else
                            System.out.println(stack[cursor - 1]);
                        break;
                }
            }
        }
    }
}
