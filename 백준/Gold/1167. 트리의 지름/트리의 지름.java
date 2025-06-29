import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int to, weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static List<Node>[] tree;
    static boolean[] visited;
    static int maxDistance = 0;
    static int farNode = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());

        tree = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            tree[i] = new ArrayList<>();
        }

        // 입력 처리
        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());

            while (true) {
                int to = Integer.parseInt(st.nextToken());
                if (to == -1) break;
                int weight = Integer.parseInt(st.nextToken());
                tree[from].add(new Node(to, weight));
            }
        }

        // 1차 DFS
        visited = new boolean[V + 1];
        dfs(1, 0);

        // 2차 DFS
        visited = new boolean[V + 1];
        maxDistance = 0;
        dfs(farNode, 0);

        System.out.println(maxDistance);
    }

    static void dfs(int node, int dist) {
        visited[node] = true;

        if (dist > maxDistance) {
            maxDistance = dist;
            farNode = node;
        }

        for (Node next : tree[node]) {
            if (!visited[next.to]) {
                dfs(next.to, dist + next.weight);
            }
        }
    }
}