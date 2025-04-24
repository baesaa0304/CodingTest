import java.io.*;
import java.util.*;

public class Main{
	
	 	static int[] T; // 상담 소요 기간
	    static int[] P; // 상담 보상
	    static int[] dp; // DP 배열

	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int n = Integer.parseInt(br.readLine()); // 총 근무일 (퇴사일)

	        T = new int[n + 1];
	        P = new int[n + 1];
	        dp = new int[n + 2]; // i+T[i]가 n+1일 될 수 있으므로 n+2까지

	        for (int i = 1; i <= n; i++) {
	            StringTokenizer st = new StringTokenizer(br.readLine());
	            T[i] = Integer.parseInt(st.nextToken());
	            P[i] = Integer.parseInt(st.nextToken());
	        }

	        System.out.println(solution(n));
	    }

	    public static int solution(int n) {
	        // 역순으로 DP 처리
	        for (int i = n; i >= 1; i--) {
	        	//System.out.println("i = " + i);
	            int endDay = i + T[i] - 1;
	            //System.out.println("endDay = " + endDay);
	            if (endDay <= n) {
	                dp[i] = Math.max(dp[i + 1], P[i] + dp[endDay + 1]);
	            } else {
	                dp[i] = dp[i + 1]; // 상담 못 하면 그대로 유지
	            }
	        }
	        return dp[1]; // 1일부터 시작할 때 최대 이익
	    }

}
