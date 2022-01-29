package BOJ;

import java.io.*;
import java.util.Scanner;

public class Main_10820_문자열분석 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = "";
        while((input = br.readLine()) != null) {
            // 소문자, 대문자, 숫자, 공백
            int[] count = new int[4];

            for(char c : input.toCharArray()) {
                if(c >= 'a' && c <= 'z') {
                    count[0] += 1;
                }
                else if(c >= 'A' && c <= 'Z') {
                    count[1] += 1;
                }
                else if(c >= '0' && c <= '9') {
                    count[2] += 1;
                }
                else {
                    count[3] += 1;
                }
            }

            for(int num : count)
                bw.write(num + " ");
            bw.write("\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
