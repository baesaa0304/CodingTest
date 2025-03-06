import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int arr[][] = new int[N][3];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		System.out.println(solution(arr, N));
	}
	  public static int solution(int arr[][], int n) {
	        int answer = Integer.MAX_VALUE;

	        for (int firstColor = 0; firstColor < 3; firstColor++) {
	            int dp[][] = new int[n][3];

	            // 첫 번째 집의 색을 firstColor로 고정하고, 나머지는 무한대로 설정
	            for (int i = 0; i < 3; i++) {
	                if (i == firstColor) {
	                    dp[0][i] = arr[0][i];
	                } else {
	                    dp[0][i] = 1000 * 1000 + 1; // 매우 큰 값(불가능한 경우)
	                }
	            }

	            // DP 계산
	            for (int i = 1; i < n; i++) {
	                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][0];
	                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1];
	                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[i][2];
	            }

	            // 마지막 집의 색이 첫 번째 집의 색과 다르게 설정
	            for (int i = 0; i < 3; i++) {
	                if (i != firstColor) { // 첫 번째 집과 색이 다를 때만 고려
	                    answer = Math.min(answer, dp[n - 1][i]);
	                }
	            }
	        }

	        return answer;
	    }
	}
