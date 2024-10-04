import java.util.*;
import java.io.*;
public class Main {
	static int max_num = Integer.MIN_VALUE;
	static int min_num =  Integer.MAX_VALUE;
	static int N;
	static int number[];
	static int operator[] = new int[4];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		number = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		
		DFS(number[0] , 1);
		
		System.out.println(max_num);
		System.out.println(min_num);
	}
	public static void DFS(int num, int idx) {
		if(idx == N) {
			max_num = Math.max(max_num, num);
		    min_num = Math.min(min_num, num);
			return;
		}
		
		for(int i =0; i < 4; i++) {
			if(operator[i] > 0) {
				
				operator[i]--;
				
				switch (i) {
				case 0:	DFS(num + number[idx], idx + 1);	break;
				case 1:	DFS(num - number[idx], idx + 1);	break;
				case 2:	DFS(num * number[idx], idx + 1);	break;
				case 3:	DFS(num / number[idx], idx + 1);	break;
				}
				// 재귀호출이 종료되면 다시 해당 연산자 개수를 복구
				operator[i]++;
			}
		}
		
	}

}
