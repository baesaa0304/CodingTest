
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.println(solution(N));
	}
	public static int solution(int n) {
		int answer = 0;
		int length = 1; // 자리수
        int start = 1;  // 자리수가 바뀌는 기준 (1, 10, 100, ...)
        
        while (start <= n) {
            int end = start * 10 - 1;
            if (end > n) {
                end = n;
            }
            answer += (end - start + 1) * length;
            start *= 10;
            length++;
        }
        return answer;
    }
}
