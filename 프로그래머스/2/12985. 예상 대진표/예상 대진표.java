class Solution{
    public int solution(int n, int a, int b) {
        int answer = 0;
     // 참가자 A와 B가 같은 라운드에 만날 때까지 반복
        while (a != b) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            answer++;
        }

        return answer;
    }
}