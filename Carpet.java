//카펫
class Solution {
    public int[] solution(int brown, int yellow) {
        for(int i = 1; i * i <= yellow; i++){
            if(yellow % i != 0) continue;
            int x = yellow / i;
            int y = i;
            if((2 * (x+2) + 2 * i) == brown) {
                int[] answer = new int[] {x+2, y + 2};
                return answer;
            }
        }
        return new int[] {-1, -1};
    }
}