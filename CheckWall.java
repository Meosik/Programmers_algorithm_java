//외벽점검

class Solution {
    public int solution(int n, int[] weak, int[] dist) {
        int answer = -1;
        int len = weak.length;
        int[] circleWeak = new int[len * 2];
        for(int i = 0; i < len; i++){
            circleWeak[i] = weak[i];
        }
        for(int i = 0; i < len; i++){
            circleWeak[i+len] = weak[i] + n;
        }
        
        int friends = 1;
        while(friends <= dist.length){
            boolean[] checked = new boolean[len];
            for(int i = dist.length-friends; i < dist.length; i++){
                
            }
        }
        

        return answer;
    }
}