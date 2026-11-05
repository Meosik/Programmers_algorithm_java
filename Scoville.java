import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++){
            queue.offer(scoville[i]);
        }
        while(queue.peek() < K){
            if(queue.size() < 2){
                return -1;
            }
            int ingredient1 = queue.poll();
            int ingredient2 = queue.poll();
            int newFood = ingredient1 + 2*ingredient2;
            queue.offer(newFood);
            answer++;
        }
        return answer;
    }
}