import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken()); // 최대 수강 가능 인원
        int L = Integer.parseInt(st.nextToken()); // 로그 수

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        // LinkedHashMap에 데이터 저장 (중복 제거 + 순서 유지)
        for (int i = 0; i < L; i++) {
            String studentId = br.readLine();  
            map.remove(studentId); // 중복 제거 (이전 값을 삭제)
            map.put(studentId, i); // 최신 값 삽입
        }

        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (String key : map.keySet()) {
            if (count == K) break; // 최대 K명까지만 출력
            sb.append(key).append("\n");
            count++;
        }

        System.out.print(sb);
    }
}
