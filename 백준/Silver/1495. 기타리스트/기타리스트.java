import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 곡의 개
		int S = Integer.parseInt(st.nextToken()); //
		int M = Integer.parseInt(st.nextToken());
		int[] volumes = new int[N+1];
		int max = -1;
		
		st = new StringTokenizer(br.readLine()); 
        for (int i = 1; i <= N; i++) {
            volumes[i] = Integer.parseInt(st.nextToken()); // 각 곡을 연주할 때 조절할 수 있는 볼륨의 변화량
        }
		int [][] dp = new int[N + 1][M + 1]; // 볼륨
		dp[0][S] = 1;
		for(int i = 1; i < N+1; i++) {
			for(int j = 0; j < M + 1; j++) {
				if(dp[i-1][j] == 1) {
					if(j + volumes[i] <= M) {
						dp[i][j+volumes[i]]=1;
					}
					if(j-volumes[i]>=0){
                        dp[i][j-volumes[i]]=1;
                    }
				}
			}
		}
		for(int i=0; i<M+1;i++){
            if(dp[N][i]==1){
                max = Math.max(max, i);

            }
        }

        System.out.println(max);
		
	}

}
