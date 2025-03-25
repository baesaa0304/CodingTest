import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		backtracking(0, 0);
		System.out.print(sb);
	}
	static void backtracking(int depth , int prev) {
		if (depth == M) { // M개를 선택하면 출력
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" "); // 배열 요소를 StringBuilder에 추가
            }
            sb.append("\n"); // 한 줄 개행 추가
            return;
        }

        for (int i = 1; i <= N; i++) {
        	if(i >= prev) {
        		arr[depth] = i; // 현재 위치에 숫자 저장
                backtracking(depth + 1, i); // 재귀 호출
        	}
        	
        }
	}

}