import java.io.*;


public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 처리
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine()); 
            int[] dp = new int[11];
            dp[1] = 1; // 1을 만드는 방법: 1
            dp[2] = 2; // 2를 만드는 방법: (1+1), (2)
            dp[3] = 4; // 3을 만드는 방법: (1+1+1), (1+2), (2+1), (3)

           
            for (int j = 4; j <= N; j++) {
                dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
            }

          
            sb.append(dp[N]).append("\n");
        }

        
        System.out.println(sb.toString());
    }
}