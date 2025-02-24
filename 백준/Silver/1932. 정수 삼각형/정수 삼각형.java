import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] triangle = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {  
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(solution(N, triangle));
    }

    public static int solution(int n, int trg[][]) {
        int[][] dp = new int[n][n];  // DP 테이블 생성
        dp[0][0] = trg[0][0];  // 첫 번째 값 초기화

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + trg[i][j];  // 왼쪽 끝
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + trg[i][j];  // 오른쪽 끝
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + trg[i][j];  // 중간 값
                }
            }
        }
        int answer = 0;
        for (int j = 0; j < n; j++) {
            answer = Math.max(answer, dp[n - 1][j]);
        }
        return answer;
    }
}