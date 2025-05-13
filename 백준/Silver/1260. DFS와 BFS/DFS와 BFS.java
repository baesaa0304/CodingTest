import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int N, M, start;
    static StringBuilder dfs = new StringBuilder();
    static StringBuilder bfs = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u); // 무방향
        }

        // 정점 번호가 작은 순서대로 방문하도록 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        DFS(start);
        System.out.println(dfs.toString().trim());

        Arrays.fill(visited, false); // 방문 배열 초기화

        BFS(start);
        System.out.println(bfs.toString().trim());
    }

    public static void DFS(int n) {
        visited[n] = true;
        dfs.append(n).append(" ");

        for (int next : graph.get(n)) {
            if (!visited[next]) {
                DFS(next);
            }
        }
    }

    public static void BFS(int n) {
        Queue<Integer> queue = new LinkedList<>();
        visited[n] = true;
        queue.offer(n);
        bfs.append(n).append(" ");

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int next : graph.get(node)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    bfs.append(next).append(" ");
                }
            }
        }
    }
}