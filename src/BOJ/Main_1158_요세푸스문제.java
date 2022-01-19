package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1158_요세푸스문제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            queue.offer(i + 1);
        }

        int count = 1;
        System.out.print("<");
        while (queue.size() > 1) {
            if(count == k) {
                // k번째 제거
                System.out.print(queue.poll() + ", ");
                count = 1;
                continue;
            }

            int numToBack = queue.poll();
            queue.offer(numToBack);

            count++;
        }

        System.out.println(queue.poll() + ">");
    }
}
