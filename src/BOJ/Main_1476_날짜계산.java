package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1476_날짜계산 {

    private static boolean isEquals(int[] answer, int[] startYear) {
        for(int i = 0; i < 3; i++) {
            if(answer[i] != startYear[i])
                return false;
        }

        return true;
    }

    private static int[] increaseYear(int[] startYear) {
        for(int i = 0; i < 3; i++) {
            startYear[i] += 1;
        }
        if(startYear[0] > 15) {
            startYear[0] = 1;
        }
        if(startYear[1] > 28) {
            startYear[1] = 1;
        }
        if(startYear[2] > 19) {
            startYear[2] = 1;
        }

        return startYear;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int[] answer = new int[3];
        for(int i = 0; i < 3; i++) {
            answer[i] = Integer.parseInt(input[i]);
        }

        int[] startYear = {1, 1, 1};

        int count = 1;
        while (!isEquals(answer, startYear)) {
            startYear = increaseYear(startYear);
            count++;
        }

        System.out.println(count);
    }
}
