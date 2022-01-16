package BOJ;

import java.util.Scanner;

public class Main_1037_약수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] divideNum = new int[n];

        for(int i = 0; i < n; i++) {
            divideNum[i] = sc.nextInt();
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int num : divideNum) {
            if(num < min)
                min = num;

            if(num > max)
                max = num;
        }


        System.out.println(min * max);
    }
}
