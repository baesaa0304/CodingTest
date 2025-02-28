import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(solution(N, arr));
	}
	public static int solution(int n , int arr[]) {
		int answer = 0;
		int fdp[] = new int[n];
		fdp[0] = arr[0];
		int fmax = arr[0];
		for(int i = 1; i < n; i++) {
			fdp[i] = Math.max(arr[i], fdp[i - 1] + arr[i]);
			fmax = Math.max(fmax, fdp[i]);
		}
		// 하나 빠진 거 
		int edp[] = new int[n];
		int emax = arr[0];
		for(int i = 1; i < n; i++) {
			edp[i] = Math.max(fdp[i - 1], edp[i - 1] + arr[i]);
			emax = Math.max(emax, edp[i]);
		}
		answer = Math.max(fmax, emax);
		
		return answer;
	}
}
