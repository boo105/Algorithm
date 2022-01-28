package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main_2866_문자열잘라내기_Important {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] rcInput = br.readLine().split(" ");

        int r = Integer.parseInt(rcInput[0]);
        int c = Integer.parseInt(rcInput[1]);

        String[] strs = new String[r];
        String[] columns = new String[c];
        Set<String> set;
        int count = 0;

        for(int i = 0; i < r; i++) {
            strs[i] = br.readLine();
        }

        for(int i = 0; i < c; i++) {    // 열 반복
            String temp = "";
            // 첫번째 행은 고려할 필요가 없음.
            for(int j = 1; j < r; j++) {    // 행 반복
                temp += strs[j].charAt(i);
            }
            columns[i] = temp;
        }

        boolean isFail = false;
        for(int i = 0; i < r; i++) {    // 행 반복
            set = new HashSet<>();
            for(int j = 0; j < c; j++) {    // 열 반복
                String str = columns[j].substring(i);
                if(set.contains(str)) {
                    isFail = true;
                    break;
                }
                else
                    set.add(str);
            }
            if(isFail)
                break;
            count++;
        }

        System.out.println(count);
    }
}
