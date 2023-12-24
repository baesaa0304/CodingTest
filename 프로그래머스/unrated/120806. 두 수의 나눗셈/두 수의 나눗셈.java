class Solution {
    public int solution(int num1, int num2) {
        double result = (double) num1 / num2;
        double answer = result * 1000;
        return (int) answer;
    }
}