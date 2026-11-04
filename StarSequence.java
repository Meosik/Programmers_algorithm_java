//스타 수열
import java.util.*;

class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int[] count = new int[a.length];
        for(int num : a){
            count[num]++;
        }
        for(int i = 0; i < a.length; i++){
            if(count[i]*2 <= answer){
                continue;
            }
            int pairs = 0;
            for(int j = 0; j < a.length -1; j++){
                if(a[j] != i && a[j+1] != i){
                    continue;
                }
                if(a[j] == a[j+1]){
                    continue;
                }
                pairs++;
                j++;
            }
            answer = Math.max(pairs*2, answer);
        }
        return answer;
    }
}