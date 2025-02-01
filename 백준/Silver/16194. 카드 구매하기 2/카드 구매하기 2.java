import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int card[] = new int[N + 1]; // 카드팩 가격 (1-based index)
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 카드 가격 입력 (card[1]부터 저장)
        for (int i = 1; i <= N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        int dp[] = new int[N + 1];

        // 최소값을 구해야 하므로 dp를 최댓값으로 초기화
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // 카드 0개 구매 비용은 0원

        for (int i = 1; i <= N; i++) { // i개의 카드를 구매하는 경우
            for (int j = 1; j <= i; j++) { // j개의 카드팩을 사용하는 경우
                dp[i] = Math.min(dp[i], dp[i - j] + card[j]);
            }
        }

        System.out.println(dp[N]);
    }
}