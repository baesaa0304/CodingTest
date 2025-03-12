
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
		int answer = 1;
		while(true) {
			 if ((answer - 1) % 15 + 1 == e &&
				(answer - 1) % 28 + 1 == s &&
		        (answer - 1) % 19 + 1 == m) {
		      return answer;
		    }
			 answer++; 
		}
		
	}
}
