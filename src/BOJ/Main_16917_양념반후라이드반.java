package BOJ;

import java.util.Scanner;

public class Main_16917_양념반후라이드반 {
    static int[] price = new int[3];
    static int[] order = new int[2];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < price.length; i++) {
            price[i] = sc.nextInt();
        }
        for(int i = 0; i < order.length; i++) {
            order[i] = sc.nextInt();
        }

        int result = 0;

        if(price[0] + price[1] <= price[2] * 2) {
            result = (price[0] * order[0]) + (price[1] * order[1]);
        }
        else {
            if(order[0] > order[1]) {
                int requireChicken = order[0] - order[1];
                result += price[2] * order[1] * 2;
                result += Math.min(price[0] * requireChicken, price[2] * requireChicken * 2);
            }
            else {
                int requireChicken = order[1] - order[0];
                result += price[2] * order[0] * 2;
                result += Math.min(price[1] * requireChicken, price[2] * requireChicken * 2);
            }
        }

        System.out.println(result);
    }
}
