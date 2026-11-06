//옹알이
import java.util.*;
class Solution {
    HashSet<String> set;
    String[] possible = new String[] {"aya", "ye", "woo", "ma"};
    boolean[] visited = new boolean[4];

    public int solution(String[] babbling) {
        int answer = 0;
        set = new HashSet<>();
        dfs("");
        
        for(String word : babbling){
            if(set.contains(word)) answer++;
        }
        return answer;
    }
    public void dfs(String s){
        for(int i = 0; i < 4; i++){
            if(visited[i]) continue;
            set.add(s+possible[i]);
            visited[i] = true;
            dfs(s+possible[i]);
            visited[i] = false;
        }
    }
}