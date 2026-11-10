import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int length = words.length;
        boolean[] visited = new boolean[length];
        boolean findTarget = false;
        for(int i = 0; i < length; i++){
            if(words[i].equals(target)){
                findTarget = true;
                break;
            }
        }
        if(!findTarget) return 0;
        int answer = 0;
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.offer(begin);
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int k = 0; k < size; k++){
                String cur = queue.poll();
                if(cur.equals(target)){
                    return answer;
                }
                for(int i = 0; i < length; i++){
                    if(visited[i]){
                        continue;
                    }
                    int count = 0;
                    for(int j = 0; j < cur.length(); j++){
                        if(cur.charAt(j)==words[i].charAt(j)){
                            count++;
                        }
                    }
                    if(count == cur.length()-1){
                        queue.offer(words[i]);
                        visited[i] = true;
                    }
                }
            }
            answer++;
        }
        return answer;
    }
}