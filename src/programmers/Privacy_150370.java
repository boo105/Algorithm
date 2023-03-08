package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Privacy_150370 {
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");

    static LocalDate todayTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String today = br.readLine();
        String[] termsInput = br.readLine().split(", ");
        termsInput = removeQuotationMark(termsInput);
        String[] privacies = br.readLine().split(", ");
        privacies = removeQuotationMark(privacies);

        todayTime = LocalDate.parse(today, formatter);
        HashMap<String, Integer> terms = makeTerms(termsInput);

        List<Integer> result = findExpiredPrivacies(privacies, terms);
        int[] test = result.stream().mapToInt(i -> i).toArray();

        for(int element : result) {
            System.out.print(element + ", ");
        }
    }

    private static List<Integer> findExpiredPrivacies(String[] privacies, HashMap<String, Integer> terms) {
        List<Integer> expiredPrivacies = new ArrayList<>();
        for(int i = 0; i < privacies.length; i++) {
            String[] privacyInfo = privacies[i].split(" ");
            LocalDate privacyCreatedDate = LocalDate.parse(privacyInfo[0], formatter);
            int expiredMonth = terms.get(privacyInfo[1]);
            LocalDate endDate = privacyCreatedDate.plusMonths(expiredMonth);

            int result = endDate.compareTo(todayTime);
            if(result <= 0) {
                expiredPrivacies.add(i + 1);
            }
        }

        return expiredPrivacies;
    }

    private static HashMap<String, Integer> makeTerms(String[] input) {
        HashMap<String, Integer> terms = new HashMap<>();
        for(String content : input) {
            String[] keyValue = content.split(" ");
            terms.put(keyValue[0], Integer.valueOf(keyValue[1]));
        }

        return terms;
    }

    private static String[] removeQuotationMark(String[] text) {
        String[] textWithoutQuotationMark = new String[text.length];
        for(int i = 0; i < text.length; i++) {
            textWithoutQuotationMark[i] = text[i].substring(1, text[i].length() - 1);
        }

        return textWithoutQuotationMark;
    }
}
