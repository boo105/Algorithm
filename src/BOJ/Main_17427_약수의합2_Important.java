package BOJ;

import java.util.Scanner;

/*
g(n) = f(n) + f(n-1) + ... + f(1)
f(1) = 1
f(2) = 1 + 2 = 3
f(3) = 1 + 3 = 4
f(4) = 1 + 2 + 4 = 8
f(5) = 1 + 5 = 6
f(6) = 1 + 2 + 3 + 6 = 12
f(7) = 1 + 7 = 8
f(8) = 1 + 2 + 4 + 8 = 15
f(9) = 1 + 3 + 9 = 13

f(9)를 기준으로 볼때
1 -> 9개,  2 -> 4개, 3 -> 3개, 4 -> 2개, 5 -> 1개, 6 -> 1개, 7 -> 1개, 8 -> 1개, 9 -> 1개
규칙을 발견하였고
9/1 = 9, 9/2 = 4, 9/3 = 3, 9/4 = 2, 9/5 = 1 ... 9/9 = 1
이라는 9를 1~9까지 나누면 몫이 해당 수의 개수가 나오게된다.
따라서 이것을 응용해서 풀면 된다

알고리즘 풀이 잘하는건
문제를 이해하는 관점이 필요하고
그 예시들의 규칙을 찾아내 알고리즘을 구현하고
반례를 찾아 고치면
알고리즘을 잘 풀수 있을것같다.
 */

public class Main_17427_약수의합2_Important {
    private static long getSumDivideNum(int num) {
        long sum = 0;

        for(int i = 1; i < num; i++) {
            int ea = num / i;
            sum += ea * i;
        }
        sum += num;

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(getSumDivideNum(n));
    }
}
