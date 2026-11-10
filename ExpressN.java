//N으로 표현

import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        List<HashSet<Integer>> dp = new ArrayList<>();
        dp.add(new HashSet<>());
        for(int i = 1; i <= 8; i++){
            HashSet<Integer> cur = new HashSet<>();
            int repeated = 0;
            for(int j = 1; j <= i; j++){
                repeated = repeated * 10 + N;
            }
            cur.add(repeated);
            for(int j = 1; j < i; j++){
                HashSet<Integer> set1 = dp.get(j);
                HashSet<Integer> set2 = dp.get(i - j);

                for(Integer num1 : set1){
                    for(Integer num2 : set2){
                        cur.add(num1 + num2);
                        cur.add(num1 - num2);
                        cur.add(num1 * num2);
                        if(num2 != 0) cur.add(num1/num2);
                    }
                }
            }
            if(cur.contains(number)) return i;
            dp.add(cur);
        }


        return -1;
    }
}