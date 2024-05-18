import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int arr[][];
	static boolean visit[][];
	static int [] dx = {-1, 1, 0, 0};
	static int [] dy = {0, 0, -1, 1};
	static int cnt;
		public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int [N][M];
		visit = new boolean[N][M];
		for(int i =0; i < N; i++) {
			String row = br.readLine();
			for(int j = 0; j < M; j++) {
				arr[i][j] = row.charAt(j) - '0';
			}
		}
		visit[0][0] = true;
		bfs(0,0);
		System.out.println(arr[N-1][M-1]);
		
	}
		public static void bfs(int x, int y) {
			Queue<int[]> que = new LinkedList<>();
			que.offer(new int[] {x, y});
			visit[x][y] = true;
			while(!que.isEmpty()) {
				int[] poll = que.poll();
				int poll_x = poll[0];
				int poll_y = poll[1];
				if(poll_x == N -1 && poll_y == M-1) {
					return;
				}
				for(int i = 0; i < 4; i++) {
					int next_x = dx[i] + poll_x;
					int next_y = dy [i] + poll_y;
					if (next_x >= 0 && next_y >= 0 && next_x < N && next_y < M && !visit[next_x][next_y] && arr[next_x][next_y] == 1) {
						que.offer(new int[] {next_x,next_y}); // 만약 상하좌우에 배추가 있고 체크하지 않은곳이라면 좌표를 지정
						visit[next_x][next_y] = true; // 체크
						arr[next_x][next_y] = arr[poll_x][poll_y] + 1;
					}
				}
			}
		}
		

}
