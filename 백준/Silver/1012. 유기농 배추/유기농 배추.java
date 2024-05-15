import java.io.*;
import java.util.*;

public class Main {
	static int T , M , N , K;
	static int arr[][];
	static boolean visit[][];
	static int cnt;
	static int [] dx = {-1, 1, 0, 0};
	static int [] dy = {0, 0, -1, 1};
	static ArrayList<Integer> result = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			cnt = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			arr= new int[M][N];
			visit = new boolean[M][N];
			
			for (int j = 0; j < K; j++){
				StringTokenizer sts = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(sts.nextToken());
				int y = Integer.parseInt(sts.nextToken());
				arr[x][y] = 1;
			}
			
			for(int k = 0; k < M; k++) {
				for(int p = 0; p < N; p++) {
					if(arr[k][p] == 1 && !visit[k][p]) {
						dfs(k, p);
						cnt++;	
					}
				}
			}
			result.add(cnt);	
		}
		for(int i =0; i < result.size(); i ++) {
			System.out.println(result.get(i));
		}

	}
	public static void dfs(int x, int y) {
		visit[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int next_x = dx[i] + x;
			int next_y = dy[i] + y;
			if (next_x >= 0 && next_y >= 0 && next_x < M && next_y < N && !visit[next_x][next_y] && arr[next_x][next_y] == 1) {
				dfs(next_x,next_y);	
			}
		}
	}

}