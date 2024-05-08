import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int bridge_weight=0;
        Queue<Integer> bridge_list  = new LinkedList<Integer>();
        
        for(int i = 0; i < truck_weights.length; i++){
        while(true){
            //다리에 트럭 없는 경우
            if(bridge_list.isEmpty()){
                bridge_list.add(truck_weights[i]);
                bridge_weight+=truck_weights[i];
                answer++;
                break;
            }
            //다리가 꽉 찬 경우
            else if(bridge_list.size()==bridge_length){
                bridge_weight-=bridge_list.poll();
            }
            else{
                //다리에 트럭을 실을 수 있을 경우
                if(bridge_weight+truck_weights[i]<=weight){
                    bridge_list.add(truck_weights[i]);
                    bridge_weight+=truck_weights[i];
                    answer++;
                    break;
                }
                else{
                    //다리에 트럭 무게가 초과인 경우
                    //가상으로 0을 채워줌
                    bridge_list.add(0);
                    answer++;
                }
                }
            }
        }
        
        //마지막 트럭이 빠져나오는 시간
        answer +=bridge_length;
        
        return answer;
    }
}