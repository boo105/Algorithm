package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9093_단어뒤집기 {
    /*
    * 중간중간 print를 하게되면 출력시간이 소요되므로
    * Stringbuilder에 추가를 하여
    * 나중에 한꺼번에 출력을 하기때문에 출력시간을 최소하 시켜서 통과했음.................
    * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();

        for(int i = 0; i < n; i++) {
            String setence = br.readLine();

            StringTokenizer st = new StringTokenizer(setence, " ", true);

            while (st.hasMoreTokens()) {
                String word = st.nextToken();
                StringBuilder sb = new StringBuilder(word);
                result.append(sb.reverse());
            }
            result.append("\n");
        }

        System.out.println(result);
    }
}
