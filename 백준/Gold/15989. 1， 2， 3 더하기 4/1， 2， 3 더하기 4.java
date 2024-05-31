import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
	    
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringBuilder sb = new StringBuilder();
		int n = stoi(br.readLine());						
		int[][] dp = new int[10001][4];// dp 배열을 선언합니다. 각 숫자를 만드는 방법의 수를 저장합니다.
		
		// dp 배열의 초기값을 설정합니다.
		dp[1][1] = 1; // 1
		dp[2][1] = 1; // 1+1
		dp[2][2] = 1; //  2
		dp[3][1] = 1; // 1+1+1
		dp[3][2] = 1; // 1+2
		dp[3][3] = 1; // 3
		
		// 4부터 10000까지 각 숫자를 만드는 방법의 수를 계산합니다.
		for(int i = 4; i <= 10000; i++) {
			dp[i][1] = dp[i-1][1]; // 'i-1'의 1로 끝나는 경우에 1을 더
			dp[i][2] = dp[i-2][1] + dp[i-2][2]; // 'i-2'의 1로 끝나는 경우와 2로 끝나는 경우에 2를 더
			dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3]; // 'i-3'의 1, 2, 3으로 끝나는 경우에 3을 더
		}
		for(int i = 0; i < n; i++) {
			int t = stoi(br.readLine());
			sb.append(dp[t][1] + dp[t][2] + dp[t][3] + "\n");
		}
		
		System.out.println(sb);
	}
	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

