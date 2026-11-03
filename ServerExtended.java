//서버 증설 횟수
import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] servers = new int[players.length];
        Arrays.fill(servers,1);
        for(int i = 0; i < players.length; i++){
            if(servers[i] * m <= players[i]){
                int extended = players[i]/m + 1 - servers[i];
                answer += extended;
               
                for (int j = i; j < Math.min(i + k, players.length); j++) {
                    servers[j] += extended;
                }
            }
        }
        return answer;
    }
}