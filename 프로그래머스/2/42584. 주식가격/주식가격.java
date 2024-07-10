import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int N = prices.length;
        int[] answer = new int[N];

        for (int i = 0; i < N; i++) {
            int duration = 0;
            for (int j = i + 1; j < N; j++) {
                duration++;
                if (prices[i] > prices[j]) {
                    break;
                }
            }
            answer[i] = duration;
        }

        return answer;
    }
}