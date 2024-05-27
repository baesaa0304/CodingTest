import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] street = br.readLine().toCharArray();
		int [] dp = new int[N];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for(int i = 1; i < dp.length; i++) {
			for (int j = 0; j < i; j++) {
				if (street[i] == 'O' && street[j] == 'B' && dp[j] != Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[i], dp[j] + (i-j)*(i-j));
				}
				else if(street[i] == 'J' && street[j] == 'O' && dp[j] != Integer.MAX_VALUE){
					dp[i] = Math.min(dp[i], dp[j] + (i-j)*(i-j));
				}else if(street[i] == 'B' && street[j] == 'J' && dp[j] != Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[i], dp[j] + (i-j)*(i-j));
				}
			}
		}if (dp[N - 1] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[N - 1]);
        }
	}

}