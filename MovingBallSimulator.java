//공 이동 시뮬레이션
class Solution {
    public long solution(int n, int m, int x, int y, int[][] queries) {

        long minX = x;
        long maxX = x;
        long minY = y;
        long maxY = y;

        for (int i = queries.length - 1; i >= 0; i--) {
            int dir = queries[i][0];
            long dist = queries[i][1];

            switch (dir) {

                case 0:
                    if (minY != 0) {
                        minY += dist;
                    }
                    maxY = Math.min(m - 1L, maxY + dist);
                    break;

                case 1:
                    minY = Math.max(0L, minY - dist);
                    if (maxY != m - 1L) {
                        maxY -= dist;
                    }
                    break;

                case 2:
                    if (minX != 0) {
                        minX += dist;
                    }
                    maxX = Math.min(n - 1L, maxX + dist);
                    break;

                case 3:
                    minX = Math.max(0L, minX - dist);
                    if (maxX != n - 1L) {
                        maxX -= dist;
                    }
                    break;
            }

            if (minX > maxX || minY > maxY) {
                return 0;
            }

            if (minX >= n || maxX < 0 ||
                minY >= m || maxY < 0) {
                return 0;
            }
        }

        return (maxX - minX + 1) * (maxY - minY + 1);
    }
}