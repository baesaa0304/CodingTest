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
        
        for(int i = 0; i < M; i++) {
            String line = br.readLine();
            for(int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j);
            }
        }
        
        int white = 0;
        int blue = 0;
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {
                    cnt = 0;
                    dfs(i, j, arr[i][j]);
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
    
    private static void dfs(int x, int y, char team) {
        visit[x][y] = true;
        cnt++;
        
        for (int i = 0; i < 4; i++) {
            int next_x = dx[i] + x;
            int next_y = dy[i] + y;
            if (next_x >= 0 && next_y >= 0 && next_x < M && next_y < N 
                && !visit[next_x][next_y] && arr[next_x][next_y] == team) {
                dfs(next_x, next_y, team);
            }
        }
    }
}
