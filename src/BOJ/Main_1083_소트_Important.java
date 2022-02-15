package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_1083_소트_Important {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        List<Integer> arr = new ArrayList<>();
        int s = Integer.parseInt(br.readLine());

        for(int i = 0; i < input.length; i++) {
            arr.add(Integer.parseInt(input[i]));
        }

        int count = 0;
        int i = 0;
        while (i < input.length -1) {
            int max = arr.get(i);
            int startPosition = i;
            int maxIdx = -1;

            int distanceCount = 1;
            i += 1;
            while (i < arr.size() && distanceCount + count <= s) {
                int currentNum = arr.get(i);
                if(max < currentNum) {
                    max = currentNum;
                    maxIdx = i;
                }
                i++;
                distanceCount++;
            }

            if(maxIdx != -1) {
                arr.remove(maxIdx);
                arr.add(startPosition, max);
                count += maxIdx - startPosition;
            }

            i = startPosition + 1;
        }

        for(int num : arr) {
            sb.append(num + " ");
        }

        System.out.println(sb);

    }
}
