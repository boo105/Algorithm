package BOJ;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main_2501_약수구하기 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        int n = Integer.parseInt(input.split(" ")[0]);
        int k = Integer.parseInt(input.split(" ")[1]);

        List<Integer> measure = new ArrayList<Integer>();

        // 정렬 요구
        for(int i = 1; i < n + 1; i++) {
            if (n % i == 0) {
                measure.add(i);
            }
        }

        // Comparator.naturalOrder() 오름차순
        // Comparator.reverseOrder() 내림차순
        measure.sort(Comparator.naturalOrder());

        try {
            System.out.println(measure.get(k - 1));
        }
        catch (Exception e) {
            System.out.println("0");
        }
    }
}
