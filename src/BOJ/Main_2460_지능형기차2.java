package BOJ;

import java.util.Scanner;

public class Main_2460_지능형기차2 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int max = 0;
        int currentTotalPeople = 0;

        for(int i = 0; i < 10; i++) {
            int currentOutPeople = sc.nextInt();
            int currentInPeople = sc.nextInt();

            currentTotalPeople -= currentOutPeople;
            currentTotalPeople += currentInPeople;

            if(currentTotalPeople > max)
                max = currentTotalPeople;
        }

        System.out.println(max);
    }
}
