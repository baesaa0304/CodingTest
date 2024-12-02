import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken()); // 트럭 수
        int w = Integer.parseInt(st.nextToken()); // 다리 길이
        int L = Integer.parseInt(st.nextToken()); // 다리 최대 하중
        
        int[] truck = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            truck[i] = Integer.parseInt(st.nextToken());
        }
        
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < w; i++) {
            que.offer(0); // 다리 초기화 (빈 공간)
        }
        
        int time = 0;  // 경과 시간
        int l_weight = 0; // 현재 다리 위의 총 무게
        int idx = 0; // 처리할 트럭의 인덱스
        
        while (idx < n) {
            // 1. 다리 끝에서 트럭 제거
            l_weight -= que.poll();
            
            // 2. 현재 트럭을 다리에 올릴 수 있는지 확인
            if (l_weight + truck[idx] <= L) {
                que.offer(truck[idx]); // 트럭을 다리에 올림
                l_weight += truck[idx];
                idx++; // 다음 트럭으로 이동
            } else {
                que.offer(0); // 무게 초과로 트럭을 올리지 못하면 빈 공간 추가
            }
            
            // 3. 시간 증가
            time++;
        }
        
        // 마지막 트럭이 다리를 완전히 건너는 시간 추가
        time += w;

        System.out.println(time);
    }
}
