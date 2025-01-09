import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list = new ArrayList<>();
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 배열 크기
            int[] numbers = new int[n];

            // 배열 입력 받기
            for (int i = 0; i < n; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            long gcdSum = 0; // 합이 클 수 있으므로 long 사용
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    gcdSum += gcd(numbers[i], numbers[j]);
                }
            }
            sb.append(gcdSum).append("\n"); // 결과 저장
        }

        // 결과 출력
        System.out.print(sb);
	}
	public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
	
}