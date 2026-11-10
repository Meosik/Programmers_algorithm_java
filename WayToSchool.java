class Solution {
    public int solution(int m, int n, int[][] puddles) {
        final int MOD = 1_000_000_007;

        int[][] dp = new int[n + 1][m + 1];

        // 물웅덩이 표시
        for (int[] puddle : puddles) {
            int x = puddle[0];
            int y = puddle[1];

            dp[y][x] = -1;
        }

        dp[1][1] = 1;

        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= m; x++) {

                // 시작점 제외
                if (x == 1 && y == 1) continue;

                // 물웅덩이는 지나갈 수 없음
                if (dp[y][x] == -1) continue;

                int fromTop = Math.max(0, dp[y - 1][x]);
                int fromLeft = Math.max(0, dp[y][x - 1]);

                dp[y][x] = (fromTop + fromLeft) % MOD;
            }
        }

        return dp[n][m];
    }
}