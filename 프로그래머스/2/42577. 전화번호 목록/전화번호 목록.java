import java.util.HashMap;

class Solution {
    public boolean solution(String[] phone_book) {
        // 전화번호를 저장할 HashMap 생성
        HashMap<String, Boolean> hashMap = new HashMap<>();
        
        // 모든 전화번호를 HashMap에 저장
        for (String phone : phone_book) {
            hashMap.put(phone, true);
        }
        
        // 각 전화번호에 대해 접두사가 있는지 확인
        for (String phone : phone_book) {
            for (int i = 1; i < phone.length(); i++) {
                // 접두사를 추출
                String prefix = phone.substring(0, i);
                
                // 접두사가 HashMap에 존재하면 false 반환
                if (hashMap.containsKey(prefix)) {
                    return false;
                }
            }
        }
        
        return true;  // 접두사가 없다면 true 반환
    }
}