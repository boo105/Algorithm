package BOJ;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_10818_최소최대 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> numbers = new ArrayList<Integer>(n);

        for(int i = 0; i < n; i++) {
            int number = sc.nextInt();
            numbers.add(number);
        }
        int max = -1000000;
        int min = 1000000;

        for(int number : numbers) {
            if(number > max)
                max = number;

            if(number < min)
                min = number;
        }

        System.out.println(min + " " + max);
    }
}
