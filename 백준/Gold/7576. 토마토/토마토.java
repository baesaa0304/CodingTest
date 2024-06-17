

import java.util.*;
import java.io.*;

public class Main {
    static int N , M; // 가로 N, 세로 M
    static int[][] tomato;
    static Queue<int[]> que = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count = 0; // 날짜를 세기 위한 변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tomato = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if (tomato[i][j] == 1) {
                    que.add(new int[] {i, j});
                }
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        while (!que.isEmpty()) {
            int[] tmp = que.poll();
            int x = tmp[0];
            int y = tmp[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                    if (tomato[nx][ny] == 0) {
                        que.add(new int[]{nx, ny});
                        tomato[nx][ny] = tomato[x][y] + 1; // 새로 추가된 곳은 원래 있던 수 + 1
                    }
                }
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (tomato[i][j] == 0) { // 그래프 안에 0 이 존재하면 답은 -1
                    return -1;
                }
                // 그래프의 날짜 중에 가장 큰 수를 찾으면 그것이 최종 날짜
                count = Math.max(count, tomato[i][j]);
            }
        }

        // 저장될 때부터 모든 토마토가 익어 있는 상태라면
        if (count == 1) {
            return 0;
        } else { // 아닐 경우 최종 날짜 - 1 출력
            return count - 1;
        }
    }
}
