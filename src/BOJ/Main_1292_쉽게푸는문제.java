package BOJ;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_1292_쉽게푸는문제 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int startNum = sc.nextInt();
        int endNum = sc.nextInt();

        int len = 1000;
        int i = 1;
        List<Integer> numbers = new ArrayList<>(len);
        while (numbers.size() < len) {
            for(int j = 0; j < i; j++) {
                numbers.add(i);
                if (numbers.size() >= len)
                    break;
            }
            i++;
        }

        int sum = 0;
        for(i = startNum; i <= endNum; i++) {
            sum += numbers.get(i - 1);
        }
        System.out.println(sum);
    }
}
