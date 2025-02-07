import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int N = Integer.parseInt(br.readLine());
	        int[] list = new int[N];
	        int[] dp = new int[N];

	        StringTokenizer st = new StringTokenizer(br.readLine());
	        for (int i = 0; i < N; i++) {
	            list[i] = Integer.parseInt(st.nextToken());
	        }

	        Arrays.fill(dp, 1); // 각 숫자는 최소 1개의 부분 수열을 가짐

	        for (int i = 1; i < N; i++) {
	            for (int j = 0; j < i; j++) {
	                if (list[j] < list[i]) { // 증가하는 경우
	                    dp[i] = Math.max(dp[i], dp[j] + 1);
	                }
	            }
	        }

	        System.out.println(Arrays.stream(dp).max().getAsInt()); // 최댓값 출력
	    }
	}