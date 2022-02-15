package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11948_과목선택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[6];
        for(int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        int max2 = 0;

        for(int i = 0; i < 4; i++) {
            if(min > arr[i]) {
                min = arr[i];
                minIndex = i;
            }
        }

        for(int i = 4; i < 6; i++) {
            if(max2 < arr[i])
                max2 = arr[i];
        }

        int result = 0;
        for(int i = 0; i < 4; i++) {
            if(i != minIndex)
                result += arr[i];
        }

        result += max2;

        System.out.println(result);
    }
}
