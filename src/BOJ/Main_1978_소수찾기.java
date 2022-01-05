package BOJ;

import java.util.Scanner;

public class Main_1978_소수찾기 {

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

        int n = sc.nextInt();
        int count = 0;
        for(int i = 0; i < n; i++) {
            boolean result = isPrimeNum(sc.nextInt());

            if(result)
                count++;
        }

        System.out.println(count);
    }
}
