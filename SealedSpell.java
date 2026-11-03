//봉인된 주문
import java.util.*;

class Solution {
    public String solution(long n, String[] bans) {

        // 주문 순서대로 정렬
        Arrays.sort(bans, (a, b) -> {
            if (a.length() != b.length()) {
                return Integer.compare(a.length(), b.length());
            }
            return a.compareTo(b);
        });

        // 금지된 주문을 숫자로 변환
        for (String banned : bans) {
            long loc = 0;

            for (int i = 0; i < banned.length(); i++) {
                loc = loc * 26 + (banned.charAt(i) - 'a' + 1);
            }

            // 목표 순서 이전에 금지 주문이 있으면 한 칸 이동
            if (loc <= n) {
                n++;
            }
        }

        // 숫자를 주문 문자열로 변환
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            n--;

            char c = (char) ('a' + n % 26);
            sb.append(c);

            n /= 26;
        }

        return sb.reverse().toString();
    }
}