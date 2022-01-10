package BOJ;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_14888_연산자끼워넣기 {
    public static int MAX = Integer.MIN_VALUE;	// 최댓값
    public static int MIN = Integer.MAX_VALUE;	// 최솟값

    // + - * / 의 순서임
    public static int[] operator = new int[4];	// 연산자 개수
    public static int[] numbers;					// 숫자
    public static int N;						// 숫자 개수

    public static void dfs(int num, int idx) {
        if (idx == N) {
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            // 연산자 개수가 1개 이상인 경우
            if (operator[i] > 0) {
                // 해당 연산자를 1 감소시킨다.
                operator[i]--;

                switch (i) {
                    case 0:	dfs(num + numbers[idx], idx + 1);	break;
                    case 1:	dfs(num - numbers[idx], idx + 1);	break;
                    case 2:	dfs(num * numbers[idx], idx + 1);	break;
                    case 3:	dfs(num / numbers[idx], idx + 1);	break;
                }
                // 재귀호출이 종료되면 다시 해당 연산자 개수를 복구한다.
                operator[i]++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        numbers = new int[N];

        for(int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        for(int i = 0; i < 4; i++) {
            operator[i] = sc.nextInt();
        }

        dfs(numbers[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);
    }
}
