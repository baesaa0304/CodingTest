import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        // 각 아이디에 신고한 유저들을 넣어준다.
        HashMap<String, HashSet<String>> reportMap = new HashMap<>();
        HashMap<String, Integer> reportCount = new HashMap<>();

        // 신고 처리
        for (String r : report) {
            String[] parts = r.split(" ");
            String reporter = parts[0]; // 신고한 아이디
            String reported = parts[1]; // 신고당한 아이디

            // 신고한 아이디가 id_list에 있는 경우에만 처리
            reportMap.putIfAbsent(reported, new HashSet<>());
            // 중복 신고 방지
            if (reportMap.get(reported).add(reporter)) {
                // 신고당한 횟수 증가 (신고자가 처음 신고한 경우에만)
                reportCount.put(reported, reportCount.getOrDefault(reported, 0) + 1);
            }
        }

        // 결과 배열 계산
        for (String reportedId : reportCount.keySet()) {
            if (reportCount.get(reportedId) >= k) {
                // 신고당한 횟수가 k 이상인 경우
                for (String reporter : reportMap.get(reportedId)) {
                    answer[getIndex(id_list, reporter)]++; // 메일 수 증가
                }
            }
        }

        return answer;
    }

    // 사용자 아이디의 인덱스 찾기
    private int getIndex(String[] id_list, String id) {
        for (int i = 0; i < id_list.length; i++) {
            if (id_list[i].equals(id)) {
                return i;
            }
        }
        return -1; // 기본적으로는 존재하지 않지만 안전을 위해
    }
}
