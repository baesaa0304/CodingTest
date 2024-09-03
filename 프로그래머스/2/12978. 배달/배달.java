import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	
	static int arr[][];
	static boolean visit[];
	static int dist[]; // 각 마을에 방문할떄 거리의 수 
    public int solution(int N, int[][] road, int K) {
        arr = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(arr[i], 500001); // 최대 거리를 큰 값으로 초기화
            arr[i][i] = 0; // 자기 자신과의 거리는 0
        }
        for (int[] r : road) {
            int u = r[0], v = r[1], w = r[2];
            arr[u][v] = Math.min(arr[u][v], w); // 최소 시간 저장
            arr[v][u] = Math.min(arr[v][u], w);
        }

        // 2. BFS 실행
       dist = bfs(N);

        // 3. 결과 계산
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                count++;
            }
        }

        return count;
    }

    // BFS 메서드
    private int[] bfs(int N) {
        dist = new int[N + 1];
        Arrays.fill(dist, 500001); // 초기값 설정
        dist[1] = 0; // 시작점(1번 마을)의 거리는 0

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        while (!queue.isEmpty()) {
            int poll = queue.poll();

            for (int i = 1; i <= N; i++) {
                if (arr[poll][i] != 500001) { // 연결된 마을이 있으면
                    int newdist = dist[poll] + arr[poll][i];
                    if (newdist < dist[i]) { // 더 짧은 거리가 있으면
                        dist[i] = newdist;
                        queue.offer(i);
                    }
                }
            }
        }

        return dist;
    }
}