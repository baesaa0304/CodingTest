import java.io.*;

public class Main {
    static int N, M;
    static char[][] board;
    static boolean[][] visited;
    static boolean hasCycle = false;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] size = br.readLine().split(" ");
        N = Integer.parseInt(size[0]);
        M = Integer.parseInt(size[1]);

        board = new char[N][M];
        visited = new boolean[N][M];

        // 보드 입력 받기
        for (int i = 0; i < N; i++) {
            String line = br.readLine(); // 띄어쓰기 없는 문자열
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        // 모든 좌표에서 DFS 시도
        for (int i = 0; i < N && !hasCycle; i++) {
            for (int j = 0; j < M && !hasCycle; j++) {
                visited = new boolean[N][M]; // 각 시작점마다 방문 초기화
                dfs(i, j, -1, -1, board[i][j]);
            }
        }

        System.out.println(hasCycle ? "Yes" : "No");
    }

    // DFS로 싸이클 탐색
    static void dfs(int x, int y, int px, int py, char color) {
        if (hasCycle) return;
        visited[x][y] = true;

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (board[nx][ny] != color) continue;

            if (!visited[nx][ny]) {
                dfs(nx, ny, x, y, color);
            } else if (!(nx == px && ny == py)) {
                // 방문한 적 있는데, 이전 위치가 아니면 싸이클
                hasCycle = true;
                return;
            }
        }
    }
}