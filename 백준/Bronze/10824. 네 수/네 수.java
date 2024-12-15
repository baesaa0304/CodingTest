import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());

	        // 네 개의 숫자를 입력받기
	        String A = st.nextToken();
	        String B = st.nextToken();
	        String C = st.nextToken();
	        String D = st.nextToken();

	        // 문자열로 이어 붙이기
	        String ab = A + B;
	        String cd = C + D;

	        // Long으로 변환 후 더하기
	        long sum = Long.parseLong(ab) + Long.parseLong(cd);

	        // 결과 출력
	        System.out.println(sum);
	    }
	}
