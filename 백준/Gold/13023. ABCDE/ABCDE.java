import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static boolean found = false;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 친구 관계 입력 받기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        // DFS 시작
        for (int i = 0; i < N; i++) {
            dfs(i, 1);
            if (found) break;
        }

        if (found) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static void dfs(int current, int depth) {
        if (depth == 5) {
            found = true;
            return;
        }

        visited[current] = true;

        for (int next : graph[current]) {
            if (!visited[next]) {
                dfs(next, depth + 1);
            }
        }

        visited[current] = false; // 백트래킹
    }
}