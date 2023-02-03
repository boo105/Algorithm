package SOFTEER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Safecracker {
    public static void main(String[] args) throws IOException {
        int bagWeight;
        int metalType;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        bagWeight = Integer.parseInt(input[0]);
        metalType = Integer.parseInt(input[1]);

        PriorityQueue<Metal> queue = new PriorityQueue<>();

        for(int i = 0; i < metalType; i++) {
            String[] metalInput = br.readLine().split(" ");
            int weight = Integer.parseInt(metalInput[0]);
            int value = Integer.parseInt(metalInput[1]);
            queue.offer(new Metal(weight, value));
        }

        int totalValue = 0;
        while (!queue.isEmpty()) {
            Metal metal = queue.poll();
            if(bagWeight < metal.weight) {
                totalValue += bagWeight * metal.value;
                break;
            }
            else {
                totalValue += metal.weight * metal.value;
                bagWeight -= metal.weight;
            }
        }

        System.out.println(totalValue);
    }

    public static class Metal implements Comparable<Metal> {
        public int weight;
        public int value;

        public Metal(int weight, int price) {
            this.weight = weight;
            this.value = price;
        }

        @Override
        public int compareTo(Metal metal) {
            return this.value < metal.value ? 1 : -1;
        }
    }
}
