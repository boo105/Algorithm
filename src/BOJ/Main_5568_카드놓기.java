package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Stack;

public class Main_5568_카드놓기 {
    static HashSet<String> hashSet = new HashSet<>();
    static Stack<Integer> stack = new Stack<>();
    static String[] arr;

    private static void pickCombination(int n,int k) {
        if(stack.size() == k) {
            String pickNum = "";
            for(int index : stack) {
                pickNum += arr[index];
            }
            if(!hashSet.contains(pickNum))
                hashSet.add(pickNum);

            return;
        }

        for(int i = 0; i < n; i++) {
            if(stack.search(i) != -1)
                continue;

            stack.push(i);

            pickCombination(n,k);
            stack.pop();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        arr = new String[n];
        for(int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        pickCombination(n, k);
        System.out.println(hashSet.size());
    }
}
