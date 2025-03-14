import java.io.*;
import java.util.*;

public class Main {
    static int N, M, maxSum = 0;
    static int[][] board;
    static boolean[][] visited;

    // 이동 방향 (상, 하, 좌, 우)
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];

        // 보드 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 모든 위치에서 탐색 시작
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, board[i][j]); // DFS 탐색 (길이 4까지)
                visited[i][j] = false;

                checkTShape(i, j); // 'ㅗ' 모양 체크
            }
        }

        System.out.println(maxSum);
    }

    // DFS를 이용해 4칸을 탐색
    static void dfs(int x, int y, int depth, int sum) {
        if (depth == 4) {
            maxSum = Math.max(maxSum, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, depth + 1, sum + board[nx][ny]);
                visited[nx][ny] = false;
            }
        }
    }

    // 'ㅗ' 모양을 완전탐색으로 처리하는 함수
    static void checkTShape(int x, int y) {
        // 'ㅗ' 모양은 4가지 변형이 있음
        int[][][] tShapes = {
            {{0, 0}, {0, -1}, {0, 1}, {1, 0}}, // ㅗ
            {{0, 0}, {-1, 0}, {1, 0}, {0, -1}}, // ㅓ
            {{0, 0}, {0, -1}, {0, 1}, {-1, 0}}, // ㅜ
            {{0, 0}, {-1, 0}, {1, 0}, {0, 1}}  // ㅏ
        };

        for (int[][] shape : tShapes) {
            int sum = 0;
            boolean isValid = true;

            for (int[] block : shape) {
                int nx = x + block[0];
                int ny = y + block[1];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    isValid = false;
                    break;
                }

                sum += board[nx][ny];
            }

            if (isValid) {
                maxSum = Math.max(maxSum, sum);
            }
        }
    }
}