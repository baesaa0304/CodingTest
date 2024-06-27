import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(getMaxSafeDistance());
    }

    private static int getMaxSafeDistance() {
        Queue<int[]> queue = new LinkedList<>();
        int[][] distances = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(distances[i], -1);
        }

        // 모든 상어의 위치를 큐에 넣고, 거리 배열 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    distances[i][j] = 0;
                }
            }
        }

        // BFS 실행
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && distances[nx][ny] == -1) {
                    distances[nx][ny] = distances[x][y] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        // 모든 거리 중 최대 거리 계산
        int maxDistance = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                maxDistance = Math.max(maxDistance, distances[i][j]);
            }
        }

        return maxDistance;
    }
}