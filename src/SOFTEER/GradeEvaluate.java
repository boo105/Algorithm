package SOFTEER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class GradeEvaluate {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        int[] totalScore = new int[N];

        for(int i = 0; i < 3; i++) {
            PriorityQueue<Competition> queue = new PriorityQueue<>();

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                int score = Integer.parseInt(st.nextToken());
                queue.offer(new Competition(j, score));
                totalScore[j] += score;
            }

            sb = appendResult(queue, sb);
            sb.append("\n");
        }

        PriorityQueue<Competition> totalQueue = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            totalQueue.offer(new Competition(i, totalScore[i]));
        }
        sb = appendResult(totalQueue, sb);
        System.out.println(sb);
    }

    static StringBuilder appendResult(PriorityQueue<Competition> queue , StringBuilder sb) {
        int[] grades = getGrade(queue);
        for(int c = 0; c < N; c++) {
            sb.append(grades[c]).append(" ");
        }

        return sb;
    }

    static int[] getGrade(PriorityQueue<Competition> queue) {
        int[] grades = new int[N];

        Competition firstParticipant = queue.poll();
        int grade = 1;
        int prevScore = firstParticipant.score;
        int sameCount = 1;

        grades[firstParticipant.idx] = grade;

        while (!queue.isEmpty()) {
            Competition participant = queue.poll();

            if(prevScore != participant.score) {
                grade += sameCount;
                sameCount = 1;
            }
            else {
                sameCount++;
            }

            grades[participant.idx] = grade;
            prevScore = participant.score;
        }

        return grades;
    }

    public static class Competition implements Comparable<Competition>{
        int idx;
        int score;

        public Competition(int idx, int score) {
            this.idx = idx;
            this.score = score;
        }

        @Override
        public int compareTo(Competition competition) {
            return competition.score - this.score;
        }
    }
}
