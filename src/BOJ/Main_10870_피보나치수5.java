package BOJ;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_10870_피보나치수5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Integer> dp = new ArrayList<>(21);

        dp.add(0);  // dp 0
        dp.add(1);  // dp 1

        for(int i = 2; i < 21; i++) {
            dp.add(dp.get(i - 1) + dp.get(i - 2));
        }

        System.out.println(dp.get(n));

    }
}
