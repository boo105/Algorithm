package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main_2751_수정렬하기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n  = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            list.add(num);
        }

        list.sort(Comparator.naturalOrder());

        for(int num : list)
            sb.append(num + "\n");

        System.out.println(sb);

    }
}
