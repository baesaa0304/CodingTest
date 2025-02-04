import java.io.*;
import java.util.*;

public class Main {
	
	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringBuilder sb = new StringBuilder();
	        
	        int T = Integer.parseInt(br.readLine());
	        int[][] dp = new int[100001][3];
	        // DP 초기화
	        dp[1][0] = 1; // 1로 끝나는 경우
	        dp[1][1] = 0;
	        dp[1][2] = 0;

	        dp[2][0] = 0;
	        dp[2][1] = 1; // 2로 끝나는 경우
	        dp[2][2] = 0;

	        dp[3][0] = 1; // 1+2
	        dp[3][1] = 1; // 2+1
	        dp[3][2] = 1; // 3

	        // DP 미리 계산
	        for (int i = 4; i <= 100000; i++) {
	            dp[i][0] = (dp[i - 1][1] + dp[i - 1][2]) % 1000000009;
	            dp[i][1] = (dp[i - 2][0] + dp[i - 2][2]) % 1000000009;
	            dp[i][2] = (dp[i - 3][0] + dp[i - 3][1]) % 1000000009;
	        }

	        // 입력값 처리
	        for (int i = 0; i < T; i++) {
	            int n = Integer.parseInt(br.readLine());
	            int result = ((dp[n][0] + dp[n][1]) % 1000000009 + dp[n][2]) % 1000000009;
	            sb.append(result).append("\n");
	        }

	        System.out.print(sb);
	    }
}
