import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        
        // 참가자의 수를 카운팅
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1); // p의 키를 가진 값은 0 아닌 경우 1
        }
        
        // 완료자의 수를 감소
        for (String c : completion) {
            map.put(c, map.get(c) - 1);
        }
        
        // 수가 0이 아닌 참가자를 찾기
        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                return key;
            }
        }
        
        return "";
    }
}