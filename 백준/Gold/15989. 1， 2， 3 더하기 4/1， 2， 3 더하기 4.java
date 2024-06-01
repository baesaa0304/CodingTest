import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
	    
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());						
		int[][] dp = new int[10001][4];// 각 숫자를 만드는 방법의 수를 저장
		
		// dp 배열의 초기값을 설정합니다.
		dp[1][1] = 1; // 1
		dp[2][1] = 1; // 1+1
		dp[2][2] = 1; // 2
		dp[3][1] = 1; // 1+1+1
		dp[3][2] = 1; // 1+2
		dp[3][3] = 1; // 3
		
		for(int i = 4; i <= 10000; i++) {
			dp[i][1] = dp[i-1][1]; 
			dp[i][2] = dp[i-2][1] + dp[i-2][2]; 
			dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3]; 
		}
		for(int i = 0; i < n; i++) {
			int t = Integer.parseInt(br.readLine());
			sb.append(dp[t][1] + dp[t][2] + dp[t][3] + "\n");
		}
		
		System.out.println(sb);
		
		// DP 배열 출력 코드 추가
//        System.out.println("DP 배열 출력:");
//        for(int i = 1; i <= 10; i++) { // 예시로 1부터 10까지만 출력
//            System.out.println("Number " + i + ": " + Arrays.toString(dp[i]));
//        }
	}
	
}

