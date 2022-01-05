package BOJ;

import java.util.*;

public class Main_2309_일곱난쟁이 {
    static List<Integer> smallPeople = new ArrayList<>(9);
    // index 값으로 존재
    static Stack<Integer> resultPeopleIndex = new Stack<>();

    private static boolean addSmallPeople(int len) {
        if (resultPeopleIndex.size() == 7) {
            int sum = 0;

            for(int index : resultPeopleIndex) {
                sum += smallPeople.get(index);
            }

            if (sum == 100)
                return true;
            else
                return false;
        }

        for(int i = 0; i < len; i++) {
            if(resultPeopleIndex.search(i) == -1) {
                resultPeopleIndex.add(i);
                boolean result = addSmallPeople(len);
                if (result)
                    return true;
                else
                    resultPeopleIndex.pop();
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 9; i++) {
            smallPeople.add(sc.nextInt());
        }
        // 재귀 반복 무조건 정답이 있기 떄문에 이렇게 해도 됨.
        addSmallPeople(smallPeople.size());

        // 정답 정렬을 위해 새로운 자료형에 넣음
        List<Integer> sortedResult = new ArrayList<>(7);
        for(int index : resultPeopleIndex) {
            sortedResult.add(smallPeople.get(index));
        }

        // 정렬 후 출력
        sortedResult.sort(Comparator.naturalOrder());
        for(int item : sortedResult) {
            System.out.println(item);
        }
    }
}
