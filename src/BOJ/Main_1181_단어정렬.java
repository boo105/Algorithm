package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main_1181_단어정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        List<String> sentences = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            sentences.add(s);
        }

        sentences.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length())
                    return o1.compareTo(o2);
                else
                    return o1.length() - o2.length();
            }
        });

        for(int i = 0; i < sentences.size(); i++) {
            String s = sentences.get(i);
            if(i != 0 && s.equals(sentences.get(i - 1))) {
                continue;
            }
            sb.append(s + "\n");
        }

        System.out.println(sb);
    }
}
