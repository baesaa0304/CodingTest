
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 세로 
		int M = Integer.parseInt(st.nextToken()); // 가로
		if(N == 1) {
			System.out.println(1);
		} else if (N == 2) {
			System.out.println(Math.min(4, (M + 1) / 2));
		} else {
			if(M < 7) {
				System.out.println(Math.min(4, M));
            } else {
            	System.out.println(M - 7 + 5);
			}
		}

	}

}
