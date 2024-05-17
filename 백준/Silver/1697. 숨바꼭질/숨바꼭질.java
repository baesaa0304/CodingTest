import java.util.*;
import java.io.*;

public class Main{
	static int N, K;
	static int arr[];
	static boolean visit[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int [100001];
		visit = new boolean[100001];
		bfs(N);
		System.out.println(arr[K]);
	}
	
	public static void bfs(int start) {
		Queue<Integer> que = new LinkedList<>();
		int next_x;
		que.offer(start);
		visit[start] = true;
		while(!que.isEmpty()) {
			int location = que.poll();
			if(location == K) {
				return;
			}
			int back = location - 1;
			int front = location + 1;
			int tele = location * 2;
			if (back >=0 && back <= 100000 && !visit[back]) {
				que.offer(back);
				visit[back] = true;
				arr[back] = arr[location] + 1;
			}
			if (front >=0 && front <= 100000 && !visit[front]) {
				que.offer(front);
				visit[front] = true;
				arr[front] = arr[location] + 1;
			}
			if (tele >=0 && tele <= 100000 && !visit[tele]) {
				que.offer(tele);
				visit[tele] = true;
				 arr[tele] = arr[location] + 1;
			}
				
			
		}
		
	}

}