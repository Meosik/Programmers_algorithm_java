//브라이언의 고민
import java.util.*;

class Solution {
    public String solution(String sentence) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> used = new HashSet<>();
        ArrayList<Integer> smallidx = new ArrayList<>();
        for(int i = 0; i < sentence.length(); i++){
            char temp = sentence.charAt(i);
            if(temp == ' '){
                return "invalid";
            }
            if(temp - 'A' < 0){
                smallidx.add(i);
            }
        }
        int length = smallidx.size();
        int start = 0;
        int end = smallidx.get(0);
        for(int i = 1; i < length; i++){
            char temp = sentence.charAt(smallidx.get(i));
            if(used.contains(temp)) return "invalid";
            if(temp != sentence.charAt(smallidx.get(i-1))){
                for(int j = start; j < end; j++){
                    if(sentence.charAt(j) - 'A' >= 0){
                        sb.append(sentence.charAt(j));
                    }
                    j++;
                }
                sb.append(' ');
                start = smallidx.get(i);
            }
            else{
                end = smallidx.get(i);
            }
        }
        
        return sb.toString();
    }
}