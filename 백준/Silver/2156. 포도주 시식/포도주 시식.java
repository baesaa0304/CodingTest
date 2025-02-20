import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int wine[] = new int[N];
        for(int i = 0; i < N; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(solution(N, wine));
    }

    public static int solution(int n, int arr[]) {
        if (n == 0) return 0; // 와인이 없는 경우
        if (n == 1) return arr[0]; // 와인이 하나만 있는 경우
        if (n == 2) return arr[0] + arr[1]; // 와인이 두 개 있는 경우

        int dp[] = new int[n];
        dp[0] = arr[0];
        dp[1] = arr[0] + arr[1];
        dp[2] = Math.max(dp[1], Math.max(arr[0] + arr[2], arr[1] + arr[2]));

        for(int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + arr[i], dp[i-3] + arr[i-1] + arr[i]));
        }
        return Math.max(dp[n-1], dp[n-2]);
    }
}