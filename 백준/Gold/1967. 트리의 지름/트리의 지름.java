import java.io.*;
import java.util.*;

//DFS로 풀이 


public class Main {
	
	static ArrayList<Integer[]> tree[];
    static boolean[] visited;
    static int max_sum;
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		visited = new boolean[N+1];
		tree = new ArrayList[N+1];
		for(int i = 1; i < tree.length; i++) {
			tree[i] = new ArrayList<>();
		}
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()); // 부모 노트 
            int v = Integer.parseInt(st.nextToken()); // 자식 노드 
            int w = Integer.parseInt(st.nextToken()); // 간선의 가중치
            tree[u].add(new Integer[] {v, w});
            tree[v].add(new Integer[] {u, w});
		}
		
        for(int i = 1; i <tree.length; i++) {
        	dfs(i,0);
        }
        System.out.println(max_sum);

	}

	private static void dfs(int node, int sum) {
		visited[node]=true;
		max_sum = Math.max(sum,max_sum);
		
		for(Integer[] temp:tree[node]) {
			int next = temp[0];
			int cost = temp[1];
			if(!visited[next]){
				dfs(next,sum+cost);
			}
			
		}
		visited[node] = false; // 방문 상태를 리셋 // 틀린부분 
		
	}

}