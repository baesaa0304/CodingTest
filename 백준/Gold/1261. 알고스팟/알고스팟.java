import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] dist;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 열
        N = Integer.parseInt(st.nextToken()); // 행
        map = new int[N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
                dist[i][j] = Integer.MAX_VALUE; // 초기값 무한대
            }
        }

        bfs();

        System.out.println(dist[N - 1][M - 1]);
    }

    public static void bfs() {
        Deque<int[]> deque = new LinkedList<>();
        dist[0][0] = 0;
        deque.offerFirst(new int[]{0, 0});

        while (!deque.isEmpty()) {
            int[] cur = deque.pollFirst();
            int x = cur[0];
            int y = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    int cost = map[nx][ny];
                    if (dist[nx][ny] > dist[x][y] + cost) {
                        dist[nx][ny] = dist[x][y] + cost;
                        if (cost == 0) {
                            deque.offerFirst(new int[]{nx, ny});
                        } else {
                            deque.offerLast(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
    }
}