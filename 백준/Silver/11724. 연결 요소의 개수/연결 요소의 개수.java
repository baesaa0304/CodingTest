import java.io.*;
import java.util.*;

public class Main {
	static int N , M;
	static int u , v;
	static int[][] arr;
	static boolean []visit;
	static int cnt;
	static Queue<Integer>que = new LinkedList<>();
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
				bfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);
		
	
	}

	public static void bfs(int start) {
		que.offer(start);
		visit[start] = true;
		while(!que.isEmpty()) {
			int temp = que.poll();
			for(int i = 1; i <=N; i++) {
				if(arr[temp][i] == 1 && !visit[i]) {
					que.offer(i);
					visit[i] = true;
				}
			}
		}
		
	}

}
