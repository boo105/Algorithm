package BOJ;

import java.util.Scanner;

public class Main_3460_이진수 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for(int i = 0; i < testCase; i++) {
            int input = sc.nextInt();

            String binary = Integer.toBinaryString(input);
            int len = binary.length();
            int k = 0;
            for(int j = len - 1; j >= 0; j--) {
                if(binary.charAt(j) == '1') {
                   System.out.print(k + " ");
                }
                k++;
            }
            System.out.println("");
        }
    }
}
