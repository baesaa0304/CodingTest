
import java.io.*;


public class Main {
	
	static int MOD = 10007;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.println(solution(N));

	}
	
	public static int solution(int n) {
		int answer = 0;
		int dp[][] = new int[n + 1][10];
		for(int i = 0; i < 10; i++) {
			dp[1][i] = 1; // 초기값을 넣어줌 
 		}
		for(int i = 2; i <= n; i++) {
		    for(int j = 0; j < 10; j++) {
		        dp[i][j] = 0; // 초기화 필요
		        for(int k = 0; k <= j; k++) {
		            dp[i][j] = (dp[i][j] + dp[i - 1][k]) % MOD;
		        }
		    }
		}
		for(int i = 0; i < 10; i++) {
			answer =  (answer + dp[n][i]) % MOD;
		}
		return answer;
	}
	
	
}
