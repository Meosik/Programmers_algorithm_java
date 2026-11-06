//당구연습

class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];

        int[][] edge = {
            {startX, 2 * n - startY},
            {startX, -startY},
            {-startX, startY},
            {2 * m - startX, startY}
        };

        for (int i = 0; i < balls.length; i++) {
            int x = balls[i][0];
            int y = balls[i][1];

            int min = Integer.MAX_VALUE;

            for (int j = 0; j < 4; j++) {

                if (j == 0 && x == startX && y > startY) {
                    continue;
                }

                if (j == 1 && x == startX && y < startY) {
                    continue;
                }

                if (j == 2 && y == startY && x < startX) {
                    continue;
                }

                if (j == 3 && y == startY && x > startX) {
                    continue;
                }

                int dx = x - edge[j][0];
                int dy = y - edge[j][1];

                int length = dx * dx + dy * dy;

                min = Math.min(min, length);
            }

            answer[i] = min;
        }

        return answer;
    }
}