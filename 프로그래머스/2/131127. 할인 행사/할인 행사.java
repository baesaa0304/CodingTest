import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < want.length; i++) {
        	map.put(want[i], number[i]);
        }
        // 할인 기간을 체크
        for (int i = 0; i <= discount.length - 10; i++) {
            HashMap<String, Integer> tempMap = new HashMap<>(map);
         // 10일 동안 할인 제품 카운트
            for (int j = 0; j < 10; j++) {
                String disc = discount[i + j];
                if (tempMap.containsKey(disc)) {
                    tempMap.put(disc, tempMap.get(disc) - 1);
                }
            }
            
            // 모든 제품의 수량이 0 이하인지 확인
            boolean join_membership = true;
            for (int count : tempMap.values()) {
                if (count > 0) {
                	join_membership = false;
                    break;
                }
            }
            
            if (join_membership) {
                answer++;
            }
        }     
        return answer;
    }
}