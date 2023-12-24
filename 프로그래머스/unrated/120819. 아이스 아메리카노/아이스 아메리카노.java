class Solution {
    public int[] solution(int money) {
        int[] answer = new int [2];
        int ice = 5500;
        answer[0] = money / ice;
        answer[1] = money % ice;
        
        return answer;
    }
}
