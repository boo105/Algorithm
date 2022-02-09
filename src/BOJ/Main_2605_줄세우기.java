package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main_2605_줄세우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] tickets = br.readLine().split(" ");

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int ticket = Integer.parseInt(tickets[i]);

            if(ticket == 0)
                list.add(i + 1);
            else {
                list.add(list.size() - ticket, i + 1);
            }
        }

        for(int num : list)
            sb.append(num + " ");

        System.out.println(sb);

    }
}
