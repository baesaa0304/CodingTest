import java.util.*;
import java.io.*;

public class Main {
    static int N, M; // 가로 세로
    static boolean [][] visit;
    static char [][] arr;
    static int cnt;
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 가로
        M = Integer.parseInt(st.nextToken()); // 세로
        arr = new char[M][N];
        visit = new boolean[M][N];
        
        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j);
            }
        }
        
        int white = 0;
        int blue = 0;
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {
                    cnt = 0;
                    bfs(i, j, arr[i][j]);
                    
                    if (arr[i][j] == 'W') {
                        white += cnt * cnt;
                    } else {
                        blue += cnt * cnt;
                    }
                }
            }
        }
        System.out.println(white + " " + blue);
    }
    
    private static void bfs(int x, int y, char team) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {x, y});
        visit[x][y] = true;
        cnt = 1;
        
        while (!que.isEmpty()) {
            int[] poll = que.poll();
            int poll_x = poll[0];
            int poll_y = poll[1];
            
            for (int i = 0; i < 4; i++) {
                int next_x = dx[i] + poll_x;
                int next_y = dy[i] + poll_y;
                
                if (next_x >= 0 && next_y >= 0 && next_x < M && next_y < N && !visit[next_x][next_y] && arr[next_x][next_y] == team) {
                    que.offer(new int[] {next_x, next_y});
                    visit[next_x][next_y] = true;
                    cnt++;
                }
            }
        }
    }
}
