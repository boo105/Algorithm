package BOJ;

import java.util.Scanner;

public class Main_2581_소수 {

    private static boolean isPrimeNum(int n) {
        if (n == 1)
            return false;

        for(int i = n - 1; i > 1; i--) {
            if (n % i == 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int sum = 0;
        int min = 10001;

        for(int i = m; i <= n; i++) {
           boolean result = isPrimeNum(i);
           if(result) {
                sum += i;
                if(i < min)
                    min = i;
           }
        }

        if(sum != 0) {
            System.out.println(sum);
            System.out.println(min);
        }
        else {
            System.out.println(-1);
        }

    }
}
