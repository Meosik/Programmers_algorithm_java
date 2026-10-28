//의상
import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> closet = new HashMap<>();

        // 종류별 의상 개수 계산
        for (String[] cloth : clothes) {
            String type = cloth[1];
            closet.put(type, closet.getOrDefault(type, 0) + 1);
        }

        int answer = 1;

        // 종류별 (의상 개수 + 안 입는 경우 1)를 곱함
        for (int count : closet.values()) {
            answer *= (count + 1);
        }

        return answer - 1;
    }
}