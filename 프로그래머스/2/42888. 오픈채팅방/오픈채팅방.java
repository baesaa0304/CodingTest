import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> map = new HashMap<>();
        int messageCount = 0; // 입장 나감 메세지를 출력을 위해 

        //  사용자 ID와 닉네임 저장
        for (String rec : record) {
            String[] parts = rec.split(" ");
            if (!parts[0].equals("Leave")) {
                map.put(parts[1], parts[2]); // Enter 또는 Change의 경우 닉네임 업데이트
                //System.out.println("map 에 값" + map);
            }
            if (!parts[0].equals("Change")) {
                messageCount++; // Enter와 Leave 메시지 수 카운트
            }
        }
        //System.out.println("총 맵 값 " + map);
        // 결과 메시지 배열 생성
        String[] answer = new String[messageCount];
        int index = 0;
        
        for (String rec : record) {
            String[] parts = rec.split(" ");
            if (parts[0].equals("Enter")) {
                answer[index++] = map.get(parts[1]) + "님이 들어왔습니다.";
            } else if (parts[0].equals("Leave")) {
                answer[index++] = map.get(parts[1]) + "님이 나갔습니다.";
            }
        }

        return answer;
    }
}