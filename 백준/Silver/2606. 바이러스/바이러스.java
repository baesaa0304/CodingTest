import java.util.*;
import java.io.*;

public class Main {
	static int node , line;
	static boolean[] visit;
	static int [][]arr;
	static int cnt;
	static Queue<Integer>que = new LinkedList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		node = Integer.parseInt(br.readLine());
        line = Integer.parseInt(br.readLine());
		int worm = 1;
		arr = new int[node + 1][node +1];
		visit = new boolean[node + 1];
		for (int i = 0; i< line; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = arr[b][a] =  1;
		}
		bfs(worm);
		System.out.println(cnt);
	}
	private static void bfs(int start) {
		que.offer(start);
		visit[start] = true;
		while(!que.isEmpty()){
			int temp = que.poll();
			for(int i = 1; i <= node; i++) {
				if(arr[temp][i] == 1 && !visit[i]) {
					que.offer(i);
					visit[i] = true;
					cnt++;
				}
			}
		}
		
	}

}
