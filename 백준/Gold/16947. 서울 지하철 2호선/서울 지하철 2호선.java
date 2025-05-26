import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static boolean[] visited;
    static boolean[] isCycleNode;
    static int[] distance;
    static int N;

    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        isCycleNode = new boolean[N + 1];
        distance = new int[N + 1];

        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        // 간선 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        // 1. 사이클 찾기
        findCycle(1, -1, new boolean[N + 1]);

        // 2. BFS로 거리 계산
        bfs();

        // 3. 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(distance[i]).append(" ");
        }
        System.out.println(sb);
    }

    // 사이클 찾기 (경로를 따라 되돌아가며 사이클 노드 추적)
    static boolean findCycle(int current, int parent, boolean[] onPath) {
        visited[current] = true;
        onPath[current] = true;

        for (int next : graph[current]) {
            if (next == parent) continue;

            if (!visited[next]) {
                if (findCycle(next, current, onPath)) {
                    if (!isCycleNode[current]) {
                        isCycleNode[current] = true;
                        return true;
                    } else {
                        // 사이클의 시작점까지 도달했으면 사이클 마킹 완료
                        return false;
                    }
                }
            } else if (onPath[next]) {
                // 사이클 시작점 발견
                isCycleNode[next] = true;
                isCycleNode[current] = true;
                return true;
            }
        }

        onPath[current] = false; // 경로에서 제거
        return false;
    }

    // BFS 거리 계산
    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visitedBfs = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            if (isCycleNode[i]) {
                queue.offer(i);
                visitedBfs[i] = true;
                distance[i] = 0;
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : graph[now]) {
                if (!visitedBfs[next]) {
                    visitedBfs[next] = true;
                    distance[next] = distance[now] + 1;
                    queue.offer(next);
                }
            }
        }
    }
}