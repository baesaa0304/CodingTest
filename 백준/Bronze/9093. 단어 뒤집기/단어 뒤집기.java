import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int N = Integer.parseInt(br.readLine());
		 StringBuilder result = new StringBuilder();
		 for (int i = 0; i < N; i++) {
			 StringTokenizer st = new StringTokenizer(br.readLine()); // 한 줄로 읽는
			 while (st.hasMoreTokens()) { // hasMoreToken 공백을 기준으로 나눔 
				 String s = st.nextToken();
				 StringBuilder sb = new StringBuilder(s);
				 result.append(sb.reverse()).append(" ");
			 }
			  result.append("\n");
		}
		 System.out.print(result.toString());
		

	}

}
