//브라이언의 고민
import java.util.*;

class Solution {
    public String solution(String sentence) {
        int n = sentence.length();

        Map<Character, List<Integer>> positions = new HashMap<>();
        Set<Character> used = new HashSet<>();

        for (int i = 0; i < n; i++) {
            char c = sentence.charAt(i);

            if (Character.isLowerCase(c)) {
                positions.computeIfAbsent(c, key -> new ArrayList<>()).add(i);
            } else if (!Character.isUpperCase(c)) {
                return "invalid";
            }
        }

        StringBuilder answer = new StringBuilder();
        int index = 0;

        while (index < n) {
            int start = index;
            int end;
            Character outer = null;
            Character inner = null;

            char first = sentence.charAt(index);

            if (Character.isLowerCase(first)) {
                if (used.contains(first)) return "invalid";

                List<Integer> pos = positions.get(first);

                if (pos.size() != 2 || pos.get(0) != index) {
                    return "invalid";
                }

                outer = first;
                end = pos.get(1);

                if (end <= start + 1) return "invalid";

                if (start + 1 < end &&
                    Character.isLowerCase(sentence.charAt(start + 2))) {
                    inner = sentence.charAt(start + 2);
                }

            } else {
                if (index + 1 < n &&
                    Character.isLowerCase(sentence.charAt(index + 1))) {

                    char marker = sentence.charAt(index + 1);
                    List<Integer> pos = positions.get(marker);

                    boolean alternating = true;

                    for (int i = 1; i < pos.size(); i++) {
                        if (pos.get(i) - pos.get(i - 1) != 2) {
                            alternating = false;
                            break;
                        }
                    }

                    if (pos.get(0) == index + 1 && alternating) {
                        inner = marker;
                        end = pos.get(pos.size() - 1) + 1;
                    } else {
                        end = index;
                    }
                } else {
                    end = index;
                }
            }

            if (outer != null) {
                if (used.contains(outer)) return "invalid";
                used.add(outer);
            }

            if (inner != null) {
                if (used.contains(inner) || inner.equals(outer)) {
                    return "invalid";
                }
                used.add(inner);
            }

            StringBuilder word = new StringBuilder();
            int contentStart = outer == null ? start : start + 1;
            int contentEnd = outer == null ? end : end - 1;

            for (int i = contentStart; i <= contentEnd; i++) {
                char c = sentence.charAt(i);

                if (Character.isUpperCase(c)) {
                    word.append(c);
                    continue;
                }

                if (inner == null || c != inner) {
                    return "invalid";
                }

                if (i <= contentStart || i >= contentEnd ||
                    !Character.isUpperCase(sentence.charAt(i - 1)) ||
                    !Character.isUpperCase(sentence.charAt(i + 1))) {
                    return "invalid";
                }
            }

            if (word.length() == 0) return "invalid";

            if (inner != null) {
                List<Integer> pos = positions.get(inner);

                if (pos.get(0) < contentStart ||
                    pos.get(pos.size() - 1) > contentEnd) {
                    return "invalid";
                }

                for (int i = 1; i < pos.size(); i++) {
                    if (pos.get(i) - pos.get(i - 1) != 2) {
                        return "invalid";
                    }
                }
            }

            if (answer.length() > 0) answer.append(' ');
            answer.append(word);

            index = end + 1;
        }

        return answer.toString();
    }
}