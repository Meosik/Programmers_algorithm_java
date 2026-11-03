//섬 연결하기
import java.util.*;

class Solution {
    int[] parent;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));
        int count = 0;
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        for(int[] cost : costs){
            if(!union(cost[0], cost[1])){
                count++;
                answer += cost[2];
            }
            if(count == n-1) break;
        }
        
        return answer;
    }
    private int find(int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    private boolean union(int x, int y){
        int rootA = find(x);
        int rootB = find(y);
        if(rootA==rootB) return true;
        parent[rootA] = rootB;
        return false;
    }
}