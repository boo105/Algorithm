package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1463_1로만들기 {
    static int[] visited;
    private static int getMin(int num) {
        if(visited[num] != 0)
            return visited[num];

        if(num == 1)
            return 0;

        int min = Integer.MAX_VALUE;
        if(num % 2 == 0)
            min = Math.min(min, getMin(num / 2));

        if(num % 3 == 0)
            min = Math.min(min, getMin(num / 3));

        min = Math.min(min, getMin(num - 1));

        visited[num] = min + 1;
        return min + 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        visited = new int[n + 1];

        int min = getMin(n);

        System.out.println(min);
    }
}
