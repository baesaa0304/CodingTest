
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    final static int MAX = 1000 + 10;
    static boolean graph[][];
    static boolean visited[];
    static int N, M;
    static int answer;

    static void dfs(int idx){
        visited[idx] = true;
        for (int i = 1; i <= N ; i++) {
            if(visited[i] == false && graph[idx][i]){
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
		    // 입출력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // graph에 연결 정보 채우기
        graph = new boolean[MAX][MAX];
        visited = new boolean[MAX];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u][v] = true; //양방향 그래프라서 [u][v], [v][u]모두 true로 설정
            graph[v][u] = true;
        }

        // dfs(재귀함수 호출)
        for (int i = 1; i <=N; i++) {
            if(visited[i] == false) { // 방문하지 않은 정점에서 dfs 호출해 연결요소 탐색
                dfs(i);
                answer++; // dfs 호출 하는 횟수가 정답
            }
        }

        // 출력
        bw.write(String.valueOf(answer));
        
        bw.close();
        br.close();
    }
}