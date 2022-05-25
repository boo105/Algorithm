package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_6064_카잉달력 {

    private static boolean isEquals(int[] standard, int[] answer) {
        for(int i = 0; i < standard.length; i++) {
            if(standard[i] != answer[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");
            int N, M;
            int[] temp = new int[2];
            N = Integer.parseInt(input[0]);
            M = Integer.parseInt(input[1]);
            for(int j = 2; j < 4; j++) {
                temp[j - 2] = Integer.parseInt(input[j]);
            }

            int[] standard = {1, 1};

            int count = 1;
            while (!isEquals(standard, temp)) {
                standard[0] += 1;
                standard[1] += 1;
                if(standard[0] > N)
                    standard[0] = 1;
                if(standard[1] > M)
                    standard[1] = 1;

                if(standard[0] == N && standard[1] == M) {
                    count++;
                    if(!(standard[0] == temp[0] && standard[1] == temp[1]))
                        count = -1;
                    break;
                }

                count++;
            }

            sb.append(count + "\n");
        }

        System.out.println(sb);

    }
}
