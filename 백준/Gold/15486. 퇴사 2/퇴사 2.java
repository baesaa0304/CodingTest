

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int schedule[][] = new int[N][2];
        int[] dp = new int[N + 1]; // 배열 크기를 N+1로 설정
        
        for (int i = 0; i < N; i++) { // 해당 날짜 상담의 소요일과 금액 저장
            String[] tp = br.readLine().split(" ");
            schedule[i][0] = Integer.parseInt(tp[0]); // 상담날짜
            schedule[i][1] = Integer.parseInt(tp[1]); // 상담 가격
        }
        
        for (int i = 0; i < N; i++) { // 반복문 범위를 i < N으로 수정
            int time = schedule[i][0];
            int pay = schedule[i][1];
            
            if (i + time - 1 < N) { // i + time - 1이 N을 초과하지 않는지 확인
                dp[i + time] = Math.max(dp[i + time], dp[i] + pay); // dp[i + time - 1]에 저장
            }
            
            dp[i + 1] = Math.max(dp[i + 1], dp[i]); // 이전 날과 오늘 중 더 큰 금액 저장
        }
        
        System.out.println(dp[N]); // 마지막 날짜 N의 최대 수익 출력
    }
}
