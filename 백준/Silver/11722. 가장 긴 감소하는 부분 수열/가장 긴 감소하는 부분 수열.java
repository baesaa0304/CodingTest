import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(solution(N, arr));
	}
	public static int solution(int n , int arr[]) {
		int answer = 0;
		int dp[] = new int[n];
		Arrays.fill(dp, 1);
		
		for(int i = 1; i < n; i++) {
			//System.out.println("i = " + arr[i]);
			int cnt = 0;
			for(int j = 0; j < i; j++) {
				//System.out.println("j = " + arr[j]);
				//System.out.println("================");
				if (arr[i] < arr[j]) { // 감소하는 부분 수열 조건
	                dp[i] = Math.max(dp[i], dp[j] + 1);
					//System.out.println("dp[i] = " + dp[i]);
				}
			}
			
		}
		
		for (int i = 0; i < n; i++) {
			answer = Math.max(answer, dp[i]);
	    }
		return answer;
	}
}
