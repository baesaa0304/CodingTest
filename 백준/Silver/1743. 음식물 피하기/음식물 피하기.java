import java.util.*;
import java.io.*;

public class Main {
    static int N, M, foodWaste;
    static int arr[][];
    static boolean visit[][];
    static int cnt;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        foodWaste = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][M + 1];
        visit = new boolean[N + 1][M + 1];
        
        for (int i = 0; i < foodWaste; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());
            arr[a][b] = 1;
        }
        
        int maxCnt = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (arr[i][j] == 1 && !visit[i][j]) {
                    cnt = 0;
                    //bfs(i, j);
                    dfs(i, j);
                    maxCnt = Math.max(maxCnt, cnt);
                }
            }
        }
        System.out.println(maxCnt);
    }

    private static void dfs(int x, int y) {
		visit[x][y] = true;
		cnt ++;
		 for (int i = 0; i < 4; i++) {
             int next_x = x + dx[i];
             int next_y = y + dy[i];
             if (next_x >= 1 && next_y >= 1 && next_x <= N && next_y <= M && !visit[next_x][next_y] && arr[next_x][next_y] == 1) {
            	 dfs(next_x , next_y);
             }
		 }
		
	}
} 