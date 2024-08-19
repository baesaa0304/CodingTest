import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static boolean[] visited;
    static List<List<Integer>> arr;
    static int n = 1;
    static int[] node; // 방문한 노드들을 순서대로 출력 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }
        visited = new boolean[N + 1];
        node = new int[N + 1];

        // 간선 입력 받기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            arr.get(v).add(u);
            arr.get(u).add(v);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(arr.get(i));
        }
        
        // DFS 시작
        DFS(start);

        // 결과 출력
        for (int i = 1; i <= N; i++) {
            System.out.println(node[i]);
        }
    }

    public static void DFS(int Node) {
        visited[Node] = true;
        node[Node] = n++;
        for (int i : arr.get(Node)) {
            if (!visited[i]) { // 방문하지 않은 인접 노드에 대해 DFS 재귀 호출
                DFS(i);
            }
        }
    }
}