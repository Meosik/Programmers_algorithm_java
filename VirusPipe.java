import java.util.*;

class Solution {
    private int n;
    private int k;
    private int answer;
    private List<int[]>[] graph;

    public int solution(int n, int infection, int[][] edges, int k) {
        this.n = n;
        this.k = k;
        this.answer = 1;
        graph = new ArrayList[n+1];

        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            int type = edge[2];

            graph[a].add(new int[]{b,type});
            graph[b].add(new int[]{a,type});
        }

        boolean[] infected = new boolean[n+1];
        infected[infection] = true;
        dfs(0,0,infected);

        return answer;
    }

    private void dfs(int depth, int lastType, boolean[] infected){
        int count = 0;
        for(int i = 1; i <= n; i ++){
            if(infected[i]) count++;
        }

        answer = Math.max(count, answer);

        if(depth == k || count == n) return;

        for(int type = 1; type <= 3; type++){
            if(type == lastType) continue;
            boolean[] next = infected.clone();
            spread(type, next);
            dfs(depth+1, type, next);
        }
    }

    private void spread(int type, boolean[] infected){
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i = 1; i <= n; i++){
            if(infected[i]){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for (int[] edge : graph[cur]) {
                int next = edge[0];
                int pipeType = edge[1];

                // 다른 타입이거나 이미 감염된 경우 제외
                if (pipeType != type || infected[next]) {
                    continue;
                }

                infected[next] = true;
                queue.offer(next);
            }
        }
    }
}