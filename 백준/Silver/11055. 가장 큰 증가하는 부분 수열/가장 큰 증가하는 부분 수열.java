import java.util.*;
import java.io.*;

public class Main {
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[]  = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(solution(N, arr));

	}
	public static int solution(int n , int arr[]) {
		int answer = 0;
		int dp[] = new int[n];
		
		//✅ 틀린 부
		for (int i = 0; i < n; i++) {
            dp[i] = arr[i]; // 기본적으로 자기 자신만 포함
		}
		
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < i; j++) {
				if(arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + arr[i]);
				}
			}
		}
		
		for(int i : dp) {
			answer = Math.max(answer, i);
		}
		return answer;
	}
}
