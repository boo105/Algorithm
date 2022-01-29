package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main_11656_접미사배열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();

        List<String> dict = new ArrayList<>();

        for(int i = 0; i < input.length(); i++) {
            String subString = input.substring(i);
            dict.add(subString);
        }

        dict.sort(Comparator.naturalOrder());
        for(String str : dict)
            sb.append(str + "\n");

        System.out.println(sb);
    }
}
