import java.util.*;
class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        HashSet<String> set = new HashSet<>();
        String[] possible = new String[] {"aya", "ye", "woo", "ma"};
        for(int i = 0; i < possible.length; i++){
            StringBuilder sb = new StringBuilder();
            sb.append(possible[i]);
            
            for
        }
        for(String babble : babbling){
            if(set.contains(babble)){
                answer++;
            }
        }
        return answer;
    }
}