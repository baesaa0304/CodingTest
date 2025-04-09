
import java.io.*;
import java.util.*;

public class Main {
	 static int N;
	    static boolean[] visited;
	    static int[] result;
	    static StringBuilder sb = new StringBuilder();

	    public static void main(String[] args) throws IOException {
	        // 입력 받기
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        N = Integer.parseInt(br.readLine());

	        visited = new boolean[N + 1];
	        result = new int[N];

	        // 순열 생성 시작
	        backtrack(0);

	        // 결과 출력
	        System.out.print(sb);
	    }

	    static void backtrack(int depth) {
	        if (depth == N) {
	            for (int num : result) {
	                sb.append(num).append(" ");
	            }
	            sb.append("\n");
	            return;
	        }

	        for (int i = 1; i <= N; i++) {
	            if (!visited[i]) {
	                visited[i] = true;
	                result[depth] = i;
	                backtrack(depth + 1);
	                visited[i] = false;
	            }
	        }
	    }
}
