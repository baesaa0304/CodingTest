import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		int dp[] = new int[N];
		int maxsum = Integer.MIN_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0]= arr[0];
		maxsum = arr[0];
		
		for (int i = 1; i < N; i++) {
            // 현재 값을 포함하는 것이 나은지, 새로 시작하는 것이 나은지 판단
            dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
            maxsum = Math.max(maxsum, dp[i]); // 최대값 갱신
        }
		System.out.println(maxsum);
	}
}
