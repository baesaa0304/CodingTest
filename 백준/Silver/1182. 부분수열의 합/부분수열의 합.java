import java.io.*;
import java.util.*;

public class Main {
	static int count = 0;
	static int N, S;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		solution(0,0);
		if (S == 0) count--;  // 공집합 제거
		System.out.println(count);
		
	} 
	public static void solution(int depth, int sum) {
		if (depth == N) {
	        if (sum == S) count++;
	        return;
	    }

		//System.out.println("포함: depth=" + (depth + 1) + ", sum=" + (sum + arr[depth]) + ", arr[depth]=" + (sum + arr[depth] - sum));

		solution(depth + 1, sum + arr[depth]);

		// 현재 원소 미포함
		//System.out.println("미포함: depth=" + (depth + 1) + ", sum=" + sum);
		solution(depth + 1, sum);
	}

}
