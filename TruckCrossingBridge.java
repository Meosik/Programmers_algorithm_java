import java.util.ArrayDeque;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int index = 0;
        int sum = 0;

        ArrayDeque<Integer> bridge = new ArrayDeque<>();

        // 다리를 빈 공간으로 초기화
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }

        // 모든 트럭이 다리에 진입할 때까지 반복
        while (index < truck_weights.length) {
            answer++;

            // 1초가 지나 맨 앞 칸이 다리에서 빠져나감
            sum -= bridge.poll();

            // 다음 트럭이 진입 가능한지 확인
            if (sum + truck_weights[index] <= weight) {
                bridge.offer(truck_weights[index]);
                sum += truck_weights[index];
                index++;
            } else {
                bridge.offer(0);
            }
        }

        // 마지막 트럭이 다리를 완전히 건너는 시간
        return answer + bridge_length;
    }
}