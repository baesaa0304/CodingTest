import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Integer>[] graph;
    static int[] order;
    static int[] visitedOrder;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        order = new int[N];
        visitedOrder = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            order[i] = Integer.parseInt(st.nextToken());
            visitedOrder[order[i]] = i;
        }

        for (int i = 1; i <= N; i++) {
            graph[i].sort(Comparator.comparingInt(a -> visitedOrder[a]));
        }

        visited = new boolean[N + 1];
        List<Integer> dfsResult = new ArrayList<>();
        dfs(1, dfsResult);

        for (int i = 0; i < N; i++) {
            if (dfsResult.get(i) != order[i]) {
                System.out.println(0);
                return;
            }
        }

        System.out.println(1);
    }

    static void dfs(int node, List<Integer> result) {
        visited[node] = true;
        result.add(node);
        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next, result);
            }
        }
    }
}