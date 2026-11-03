//단속카메라
import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int cars = routes.length;
        Arrays.sort(routes, (o1, o2)-> o1[1] - o2[1]);
        int camera = -30001;
        int answer = 0;
        for(int i = 0; i < cars; i++){
            if(routes[i][0] > camera){
                answer++;
                camera = routes[i][1];
            }
        }
        return answer;
    }
}