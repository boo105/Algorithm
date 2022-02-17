package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main_11723_집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        HashSet<Integer> group = new HashSet<>();

        for(int i = 0; i < n; i++) {
            String[] commands = br.readLine().split(" ");
            switch (commands[0]) {
                case "add" :
                    group.add(Integer.parseInt(commands[1]));
                    break;
                case "remove" :
                    group.remove(Integer.parseInt(commands[1]));
                    break;
                case "check" :
                    if(group.contains(Integer.parseInt(commands[1]))) {
                        sb.append(1 + "\n");
                    }
                    else
                        sb.append(0 + "\n");
                    break;
                case "toggle" :
                    int num = Integer.parseInt(commands[1]);
                    if(group.contains(num))
                        group.remove(num);
                    else
                        group.add(num);
                    break;
                case "all" :
                    for(int j = 1; j <= 20; j++)
                        group.add(j);
                    break;
                case "empty" :
                    group.clear();
                    break;
            }
        }

        System.out.println(sb);
    }
}

