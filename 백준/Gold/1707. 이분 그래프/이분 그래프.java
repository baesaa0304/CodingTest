import java.io.*;
import java.util.*;

public class Main {
	static int K;
	static int V;
	static int E;
	static List<List<Integer>> arr = new ArrayList<>();
	static boolean[] visited;
	static int[] color;
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    K = Integer.parseInt(br.readLine());

	    StringBuilder sb = new StringBuilder();

	    for (int test = 0; test < K; test++) {
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        V = Integer.parseInt(st.nextToken());
	        E = Integer.parseInt(st.nextToken());

	        // 그래프, 방문 배열, 색 배열 초기화
	        arr = new ArrayList<>();
	        for (int i = 0; i <= V; i++) {
	            arr.add(new ArrayList<>());
	        }

	        visited = new boolean[V + 1];
	        color = new int[V + 1];

	        // 간선 입력
	        for (int i = 0; i < E; i++) {
	            st = new StringTokenizer(br.readLine());
	            int u = Integer.parseInt(st.nextToken());
	            int v = Integer.parseInt(st.nextToken());

	            arr.get(u).add(v);
	            arr.get(v).add(u);
	        }

	        boolean isBipartite = true;
	        for (int i = 1; i <= V; i++) {
	            if (!visited[i]) {
	                if (!BFS(i)) {
	                    isBipartite = false;
	                    break;
	                }
	            }
	        }

	        if (isBipartite) {
	            sb.append("YES\n");
	        } else {
	            sb.append("NO\n");
	        }
	    }

	    System.out.print(sb.toString());
	}
	public static boolean BFS(int start) {
	    Queue<Integer> queue = new LinkedList<>();
	    queue.offer(start);
	    visited[start] = true;
	    color[start] = 0; // 시작 정점 색을 0으로 지정

	    while (!queue.isEmpty()) {
	        int node = queue.poll();

	        for (int next : arr.get(node)) {
	            if (!visited[next]) {
	                visited[next] = true;
	                color[next] = 1 - color[node]; // 다른 색으로 칠하기
	                queue.offer(next);
	            } else {
	                // 이미 방문한 경우, 색이 같다면 이분 그래프가 아님
	                if (color[next] == color[node]) {
	                    return false; // 이분 그래프 아님
	                }
	            }
	        }
	    }

	    return true; // 이분 그래프 조건 만족
	}

}
