import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(solution(N));
    }

    public static int solution(int n) {
        if (n % 2 == 1) { // 홀수인 경우는 채울 수 없음
            return 0;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1; // 공집합 개념
        dp[2] = 3; // 3x2 타일을 채우는 기본적인 방법

        for (int i = 4; i <= n; i += 2) {
            dp[i] = dp[i - 2] * 3; // 기본적인 3x2 타일링 추가
            for (int j = i - 4; j >= 0; j -= 2) {
                dp[i] += dp[j] * 2; // 새로운 패턴 적용
            }
        }

        return dp[n]; // 최종 결과 반환
    }
}