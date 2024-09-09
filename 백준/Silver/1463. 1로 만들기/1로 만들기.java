import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		// dp 배열 선언 및 초기화
        int[] dp = new int[X + 1];
        
        dp[1] = 0; // 1은 이미 1이므로 연산 필요 없음

        for (int i = 2; i <= X; i++) {
            // 우선 1을 빼는 경우 (dp[i - 1])
            dp[i] = dp[i - 1] + 1;

            // 2로 나누어 떨어지는 경우
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            // 3으로 나누어 떨어지는 경우
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        // 결과 출력
        System.out.println(dp[X]);
    }
}