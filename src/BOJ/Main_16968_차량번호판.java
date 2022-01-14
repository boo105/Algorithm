package BOJ;

import java.util.Scanner;
import java.util.Stack;

public class Main_16968_차량번호판 {
    static Stack<Character> carLicense = new Stack<>();
    static String input = null;
    static int countLicense = 0;

    private static void getCountCarLicense(int index) {
        if(index == input.length()) {
            countLicense++;
            return;
        }

        char mode = input.toCharArray()[index];

        if (mode == 'c') {
            for(char c = 'a'; c <= 'z'; c++) {
                if(!carLicense.isEmpty() && isSameWords(carLicense.peek(), c)) {
                    continue;
                }

                carLicense.push(c);
                getCountCarLicense(index + 1);
                carLicense.pop();
            }
        }
        else if(mode == 'd') {
            for(char digit = '0'; digit <= '9'; digit++) {
                if(!carLicense.isEmpty() && isSameWords(carLicense.peek(), digit)) {
                    continue;
                }

                carLicense.push(digit);
                getCountCarLicense(index + 1);
                carLicense.pop();
            }
        }
    }

    private static boolean isSameWords(char first, char second) {
        return first == second;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        input = sc.nextLine();

        getCountCarLicense(0);

        System.out.println(countLicense);
    }
}
