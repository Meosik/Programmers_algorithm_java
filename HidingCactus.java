//선인장 숨기기
import java.util.*;

class Solution {
    public int[] solution(int m, int n, int h, int w, int[][] drops) {

        int INF = drops.length + 1;

        int[][] rain = new int[m][n];

        for (int[] row : rain) {
            Arrays.fill(row, INF);
        }

        for (int i = 0; i < drops.length; i++) {
            int r = drops[i][0];
            int c = drops[i][1];

            rain[r][c] = i + 1;
        }

        int cols = n - w + 1;
        int[][] rowMin = new int[m][cols];

        for (int r = 0; r < m; r++) {
            ArrayDeque<Integer> deque = new ArrayDeque<>();

            for (int c = 0; c < n; c++) {

                while (!deque.isEmpty()
                        && deque.peekFirst() <= c - w) {
                    deque.pollFirst();
                }

                while (!deque.isEmpty()
                        && rain[r][deque.peekLast()] >= rain[r][c]) {
                    deque.pollLast();
                }

                deque.offerLast(c);

                if (c >= w - 1) {
                    rowMin[r][c - w + 1] =
                            rain[r][deque.peekFirst()];
                }
            }
        }

        int best = -1;
        int[] answer = new int[2];

        for (int c = 0; c < cols; c++) {
            ArrayDeque<Integer> deque = new ArrayDeque<>();

            for (int r = 0; r < m; r++) {

                while (!deque.isEmpty()
                        && deque.peekFirst() <= r - h) {
                    deque.pollFirst();
                }

                while (!deque.isEmpty()
                        && rowMin[deque.peekLast()][c] >= rowMin[r][c]) {
                    deque.pollLast();
                }

                deque.offerLast(r);

                if (r >= h - 1) {
                    int minTime = rowMin[deque.peekFirst()][c];

                    int startRow = r - h + 1;

                    if (minTime > best) {
                        best = minTime;
                        answer[0] = startRow;
                        answer[1] = c;
                    }

                    else if (minTime == best) {
                        if (startRow < answer[0]
                                || (startRow == answer[0]
                                && c < answer[1])) {

                            answer[0] = startRow;
                            answer[1] = c;
                        }
                    }
                }
            }
        }

        return answer;
    }
}