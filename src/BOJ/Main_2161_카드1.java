package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main_2161_카드1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        while (queue.size() != 1) {
            int dropCard = queue.poll();
            sb.append(dropCard + " ");
            int tempCard = queue.poll();
            queue.offer(tempCard);
        }
        sb.append(queue.poll());
        System.out.println(sb);
    }
}
