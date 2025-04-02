import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	 static int[] input;
	 static int[] result;
	 static boolean[] visited;
	 static StringBuilder sb = new StringBuilder(); // 출력 속도 향상
	 public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		  StringTokenizer st = new StringTokenizer(br.readLine());
	        N = Integer.parseInt(st.nextToken());
	        M = Integer.parseInt(st.nextToken());

	        // 수열 입력
	        input = new int[N];
	        result = new int[M];
	        visited = new boolean[N];

	        st = new StringTokenizer(br.readLine());
	        for (int i = 0; i < N; i++) {
	            input[i] = Integer.parseInt(st.nextToken());
	        }

	        Arrays.sort(input); // 사전 순 출력을 위해 정렬
	        backtracking(0 , 0);

	        System.out.print(sb);
	    }

	    public static void backtracking(int depth , int prev) {
	        if (depth == M) {
	            for (int i = 0; i < M; i++) {
	                sb.append(result[i]).append(" ");
	            }
	            sb.append("\n");
	            return;
	        }

	        for (int i = prev; i < N; i++) {
	        	if (i > 0 && input[i] == input[i - 1] && !visited[i - 1]) continue;
	            if (!visited[i]) {
	                visited[i] = true;
	                result[depth] = input[i];
	                backtracking(depth + 1 , i);
	                visited[i] = false;
	            }
	        }
	    }    
	}
