package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class MBTI_118666 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] survey = br.readLine().split(", ");
        String[] choicesHolder = br.readLine().split(", ");
        int[] choices = new int[choicesHolder.length];
        for (int i = 0; i < choicesHolder.length; i++) {
            choices[i] = Integer.parseInt(choicesHolder[i]);
        }

        HashMap<Character, Integer> surveyResult = getKakaoMBTI(survey, choices, surveyResultInit());
        printMyKakaoMBTI(surveyResult);
    }

    private static HashMap<Character, Integer> surveyResultInit() {
        HashMap<Character, Integer> surveyResult = new HashMap<>();
        String[] mbtiType = {"RT", "CF", "JM", "AN"};

        for(String type : mbtiType) {
            for(int i = 0; i < type.length(); i++) {
                Character detailType = type.charAt(i);
                surveyResult.putIfAbsent(detailType, 0);
            }
        }

        return surveyResult;
    }

    private static void printMyKakaoMBTI(HashMap<Character, Integer> surveyResult) {
        StringBuilder sb = new StringBuilder();
        String[] mbtiType = {"RT", "CF", "JM", "AN"};

        for (String type : mbtiType) {
            Character firstType = type.charAt(0);
            Character secondType = type.charAt(1);

            int first = surveyResult.get(firstType);
            int second = surveyResult.get(secondType);

            if(surveyResult.get(firstType) > surveyResult.get(secondType)) {
                sb.append(firstType);
            }
            else if(surveyResult.get(firstType) < surveyResult.get(secondType)) {
                sb.append(secondType);
            }
            else {
                int diff = firstType - secondType;
                if(diff > 0) {
                    sb.append(secondType);
                }
                else {
                    sb.append(firstType);
                }
            }
        }
    }

    private static HashMap<Character, Integer> getKakaoMBTI(String[] survey, int[] choices, HashMap<Character, Integer> surveyResult) {
        for(int i = 0; i < choices.length; i++) {
            int choice = choices[i];
            int scoreWithDirection = choice - 4;
            int score = Math.abs(scoreWithDirection);

            Character pickCharacter = null;
            if(scoreWithDirection < 0) {
                pickCharacter = survey[i].charAt(0);
            }
            else if(scoreWithDirection > 0) {
                pickCharacter = survey[i].charAt(1);
            }

            if(scoreWithDirection != 0) {
                Integer result = surveyResult.get(pickCharacter);
                surveyResult.put(pickCharacter, result + score);
            }
        }

        return surveyResult;
    }
}
