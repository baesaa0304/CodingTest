import java.util.LinkedList;
import java.util.Queue;

class Solution {

    static class Node {
        int x;
        int y;
        int dir;
        int cost;

        Node(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }

    static int N;
    static int M;
    static int[][] arr;
    static int cost = Integer.MAX_VALUE;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int corner = 500; // 코너 값
    static int straight = 100; // 직진 값

    public int solution(int[][] board) {
        N = board.length;
        M = board[0].length;
        arr = board;
        BFS(0, 0);
        return cost;
    }

    private void BFS(int x, int y) {
        Queue<Node> que = new LinkedList<>();
        int[][][] costs = new int[N][M][4]; // 각 좌표에 비용을 저장하는 배열
        
        // 비용 배열 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < 4; k++) {
                    costs[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        // 처음 시작할 때 4방향 모두 큐에 추가 (x, y, 방향, 비용 0)
        for (int i = 0; i < 4; i++) {
            que.offer(new Node(x, y, i, 0));
            costs[x][y][i] = 0; // 처음 출발하는 좌표는 비용이 0
        }

        // BFS 탐색 시작
        while (!que.isEmpty()) {
            Node current = que.poll();
            int curr_x = current.x;
            int curr_y = current.y;
            int curr_dir = current.dir;
            int curr_cost = current.cost;

            // 목적지에 도달하면 최소 비용 갱신
            if (curr_x == N - 1 && curr_y == M - 1) {
                cost = Math.min(cost, curr_cost);
            }

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int next_x = curr_x + dx[i];
                int next_y = curr_y + dy[i];
                int new_cost = curr_cost;

                // 범위 안에 있는지 확인
                if (next_x >= 0 && next_x < N && next_y >= 0 && next_y < M) {
                    if (arr[next_x][next_y] != 1) { // 벽이 아니면
                        if (i == curr_dir) {
                            new_cost += straight; // 같은 방향이면 직진 비용 추가
                        } else {
                            new_cost += straight + corner; // 방향이 바뀌면 코너 비용 추가
                        }

                        // 더 적은 비용으로 해당 좌표에 도착할 수 있는 경우
                        if (new_cost < costs[next_x][next_y][i]) {
                            costs[next_x][next_y][i] = new_cost;
                            que.offer(new Node(next_x, next_y, i, new_cost));
                        }
                    }
                }
            }
        }
    }
}