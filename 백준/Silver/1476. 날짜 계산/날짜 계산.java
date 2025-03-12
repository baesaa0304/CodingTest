import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		System.out.println(solution(E, S, M));

	}
	public static int solution(int e , int s ,int m) {
		int answer = 0;
		int a = 0;
		int b = 0;
		int c = 0;
		while(true) { 
			answer++;
			a++; 
			b++; 
			c++;
			if(a == 16) a = 1;
			if(b == 29) b = 1;
			if(c == 20) c = 1;
			if(a == e && b == s && c == m) break;
		}
		return answer;
	}
}