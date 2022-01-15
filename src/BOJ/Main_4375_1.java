package BOJ;

import java.util.Scanner;

public class Main_4375_1 {
    private static void one(int n) {
        int preOne = 0;

        for(int i = 1; ; i++) {
            preOne = ((preOne * 10) + 1) % n;

            if(preOne == 0) {
                System.out.println(i);
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            one(n);
        }
    }
}
