package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main_11399_ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        List<Integer> waitTime = new ArrayList<>();
        for(String time : input) {
            waitTime.add(Integer.parseInt(time));
        }
        waitTime.sort(Comparator.naturalOrder());

        int totalTime = 0;
        int result = 0;
        for(int time : waitTime) {
            totalTime += time;
            result += totalTime;
        }
        System.out.println(result);
    }
}
