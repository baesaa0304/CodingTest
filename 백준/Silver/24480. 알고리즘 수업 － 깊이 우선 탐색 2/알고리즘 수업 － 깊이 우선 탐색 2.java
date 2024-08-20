import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static boolean[] visited;
    static List<List<Integer>> arr;
    static int n = 1;
    static int node[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); // 노드의 수
        M = Integer.parseInt(st.nextToken()); // 간선의 수
        int start = Integer.parseInt(st.nextToken()); // 시작 노드
        
        arr = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }
        
        visited = new boolean[N + 1];
        node = new int[N + 1];
        
        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            arr.get(v).add(u);
            arr.get(u).add(v);
        }
        
        // 인접 리스트 내림차순 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(arr.get(i), Collections.reverseOrder());
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
        
        // 인접한 노드들에 대해 재귀적으로 DFS 수행
        for (int i : arr.get(Node)) {
            if (!visited[i]) {  // 방문 여부 체크
                DFS(i);
            }
        }
    }
}