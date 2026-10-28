//디스크컨트롤러(우선순위큐 1개)
import java.util.*;

class Solution {

    record Job(int number, int requestTime, int workTime) {};

    public int solution(int[][] jobs) {
        int length = jobs.length;
        Job[] sorted = new Job[length];
        for(int i = 0; i < length; i++){
            sorted[i] = new Job(i, jobs[i][0], jobs[i][1]);
        }
        Arrays.sort(sorted, Comparator.comparingInt(Job::requestTime).thenComparingInt(Job::number));
        int time = 0;
        int index = 0;
        int completed = 0;
        int totalTime = 0;
        PriorityQueue<Job> waiting = new PriorityQueue<>();

        while (completed < length) {

            // 현재 시각까지 요청된 작업 추가
            while (index < length &&
                   sorted[index].requestTime() <= time) {
                waiting.offer(sorted[index++]);
            }

            // 대기 작업이 없으면 다음 요청 시각으로 이동
            if (waiting.isEmpty()) {
                time = sorted[index].requestTime();
                continue;
            }

            // 가장 우선순위가 높은 작업 실행
            Job current = waiting.poll();

            time += current.workTime();
            totalTime += time - current.requestTime();

            completed++;
        }

        return totalTime / length;
    }
}