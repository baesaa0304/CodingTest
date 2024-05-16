import java.util.*;
import java.io.*;


public class Main {
	static int N , M;
	static int u , v;
	static int[][] arr;
	static boolean []visit;
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1][N+1];
		visit = new boolean[N+1];
		for(int i = 0; i < M; i++) {
			StringTokenizer sts = new StringTokenizer(br.readLine());
			u = Integer.parseInt(sts.nextToken());
			v = Integer.parseInt(sts.nextToken());
			arr[u][v] = arr[v][u] = 1;
		}
		for(int i =1; i <= N; i++) {
			if(!visit[i]) {
				dfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}
	public static void dfs(int start) {
		visit[start] = true;
		for(int i = 1; i <= N; i++) {
			if(arr[start][i] == 1 && !visit[i]) {
				dfs(i);
			}
		}
		
	}

}