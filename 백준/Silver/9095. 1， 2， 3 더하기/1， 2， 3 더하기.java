import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
			
		while(T-- > 0) {
			 int N = Integer.parseInt(br.readLine()); 
			 System.out.println(solution(N));
		}

	}
	
	public static int solution(int n) {
		if(n == 0) return 1;
		if(n < 0) return 0;
		
		return solution(n - 1) + solution(n - 2) + solution(n - 3);
	}
}
