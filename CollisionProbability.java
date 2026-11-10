//충돌위험찾기
import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        int x = routes.length;
        int pointN = routes[0].length;

        ArrayList<ArrayList<int[]>> location = new ArrayList<>();

        for (int i = 0; i < x; i++) {
            location.add(new ArrayList<>());
        }

        for (int robot = 0; robot < x; robot++) {

            int start = routes[robot][0] - 1;

            int robotr = points[start][0];
            int robotc = points[start][1];

            location.get(robot).add(new int[]{robotr, robotc});

            for (int i = 1; i < pointN; i++) {

                int target = routes[robot][i] - 1;

                int targetR = points[target][0];
                int targetC = points[target][1];

                while (robotr != targetR) {
                    if (targetR > robotr) {
                        robotr++;
                    } else {
                        robotr--;
                    }

                    location.get(robot).add(new int[]{robotr, robotc});
                }

                while (robotc != targetC) {
                    if (targetC > robotc) {
                        robotc++;
                    } else {
                        robotc--;
                    }

                    location.get(robot).add(new int[]{robotr, robotc});
                }
            }
        }

        int end = 0;

        for (int i = 0; i < x; i++) {
            end = Math.max(end, location.get(i).size());
        }

        for (int t = 0; t < end; t++) {

            HashSet<Integer> tLocation = new HashSet<>();
            HashSet<Integer> collision = new HashSet<>();

            for (int i = 0; i < x; i++) {

                if (t >= location.get(i).size()) {
                    continue;
                }

                int[] pos = location.get(i).get(t);
                int tRobot = pos[0] * 1000 + pos[1];

                if (!tLocation.add(tRobot)) {
                    collision.add(tRobot);
                }
            }

            answer += collision.size();
        }

        return answer;
    }
}