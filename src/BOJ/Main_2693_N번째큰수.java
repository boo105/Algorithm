package BOJ;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main_2693_N번째큰수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 3;
        int testCase = sc.nextInt();
        List<Integer> result = new ArrayList<>(testCase);

        for(int i = 0; i < testCase; i++) {
            List<Integer> numbers = new ArrayList<>(10);
            for(int j = 0; j < 10; j++) {
                numbers.add(sc.nextInt());
            }

            numbers.sort(Comparator.reverseOrder());
            result.add(numbers.get(n - 1));
        }

        for(int item : result)
           System.out.println(item);

    }
}
