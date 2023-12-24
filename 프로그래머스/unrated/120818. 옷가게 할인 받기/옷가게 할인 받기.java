class Solution {
    public int solution(int price) {
        int answer = 0;
        if(100000 <= price && 300000 > price ){
            answer = price * 95 / 100;
        } else if (300000 <= price && 500000 > price){
            answer = price * 90 / 100;
        } else if (500000 <= price) {
            answer = price * 80 /100;
        } else if(100000 > price) {
            answer = price;
        }
        return answer;
    }
}