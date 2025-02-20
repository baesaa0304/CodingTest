import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            int M = Integer.parseInt(br.readLine());
            int sticker[][] = new int[2][M];
            for(int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k = 0; k < M; k++) {
                    sticker[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println(solution(M, sticker));
        }
    }

    public static int solution(int m, int arr[][]) {
        if (m == 1) {
            // M이 1일 경우, 두 스티커 중 더 큰 값을 반환
            return Math.max(arr[0][0], arr[1][0]);
        }

        int dp[][] = new int[2][m];
        dp[0][0] = arr[0][0];
        dp[1][0] = arr[1][0];

        if (m > 1) {
            dp[0][1] = dp[1][0] + arr[0][1];
            dp[1][1] = dp[0][0] + arr[1][1];
        }

        for(int i = 2; i < m; i++) {
            dp[0][i] = Math.max(dp[1][i-1], Math.max(dp[0][i-2], dp[1][i-2])) + arr[0][i];
            dp[1][i] = Math.max(dp[0][i-1], Math.max(dp[0][i-2], dp[1][i-2])) + arr[1][i];
        }

        return Math.max(dp[0][m-1], dp[1][m-1]);
    }
}