package BOJ;

import java.util.Scanner;

public class Main_2609_최대공약수와최소공배수 {

    // 유클리드 호제법으로 구하는법
    private static int getGCD(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }

    //
    private static int getLCM(int a, int b) {
        return a * b / getGCD(a, b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        int gcd = getGCD(num1, num2);
        int lcm = getLCM(num1, num2);

        System.out.println(gcd);
        System.out.println(lcm);
    }
}
