//디스크컨트롤러(우선순위큐 2개)
import java.util.PriorityQueue;

class Solution {

    class Job {
        int number;
        int requestTime;
        int workTime;

        public Job(int number, int requestTime, int workTime) {
            this.number = number;
            this.requestTime = requestTime;
            this.workTime = workTime;
        }
    }

    public int solution(int[][] jobs) {
        int totalTime = 0;
        int currentTime = 0;

        // 요청 시각이 빠른 순서
        PriorityQueue<Job> queue = new PriorityQueue<>(
            (a, b) -> {
                if (a.requestTime != b.requestTime) {
                    return Integer.compare(a.requestTime, b.requestTime);
                }
                return Integer.compare(a.number, b.number);
            }
        );

        // 작업 소요 시간이 짧은 순서
        PriorityQueue<Job> waiting = new PriorityQueue<>(
            (a, b) -> {
                if (a.workTime != b.workTime) {
                    return Integer.compare(a.workTime, b.workTime);
                }
                if (a.requestTime != b.requestTime) {
                    return Integer.compare(a.requestTime, b.requestTime);
                }
                return Integer.compare(a.number, b.number);
            }
        );

        // 모든 작업을 요청 큐에 삽입
        for (int i = 0; i < jobs.length; i++) {
            queue.offer(new Job(i, jobs[i][0], jobs[i][1]));
        }

        while (!queue.isEmpty() || !waiting.isEmpty()) {

            // 현재 시각까지 요청된 모든 작업을 대기 큐에 삽입
            while (!queue.isEmpty()
                    && queue.peek().requestTime <= currentTime) {

                waiting.offer(queue.poll());
            }

            // 실행 가능한 작업이 없다면 다음 요청 시각으로 이동
            if (waiting.isEmpty()) {
                currentTime = queue.peek().requestTime;
                continue;
            }

            // 대기 중 소요 시간이 가장 짧은 작업 실행
            Job working = waiting.poll();

            currentTime += working.workTime;

            // 반환 시간 = 완료 시각 - 요청 시각
            totalTime += currentTime - working.requestTime;
        }

        return totalTime / jobs.length;
    }
}