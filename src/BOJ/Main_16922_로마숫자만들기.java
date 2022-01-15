package BOJ;

import java.util.Scanner;

public class Main_16922_로마숫자만들기 {
    /*
    * 초반에 푼 방식도 맞긴했는데 시간이 너무 오래걸리기때문에
    * 분기점을 줘서 반복을 최소화 하는 방법으로 바꿈.
    * */
    static final int[] romaDigits = {1, 5, 10, 50};
    static boolean visit[];
    static int result = 0;
    static int n = 0;

    private static void countRoma(int index, int sum ,int depth) {
        if(depth == 0) {
            if(!visit[sum]) {
                visit[sum] = true;
                result++;
            }

            return;
        }

        // bound를 주는 이유는 모든 반복을 0 부터 돌지않아도 초반 0에서 계산만하면 계산이 되기때문에
        for(int i = index; i < 4; i++) {
            countRoma(i,sum + romaDigits[i], depth - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        visit = new boolean[1001];
        countRoma(0,0, n);
        System.out.println(result);
    }
}
