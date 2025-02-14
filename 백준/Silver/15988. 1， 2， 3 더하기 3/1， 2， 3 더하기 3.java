import java.io.*;

public class Main {
	static int mod = 1_000_000_009;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long dp[] = new long[1_000_001];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for(int j = 4; j <= 1_000_000; j++) {
			dp[j] = (dp[j - 1] + dp[j - 2] + dp[ j - 3]) % mod;
		}
		for (int i = 0; i < N; i++) {
			int T = Integer.parseInt(br.readLine());
			System.out.println(dp[T]);
		}
	}
}
