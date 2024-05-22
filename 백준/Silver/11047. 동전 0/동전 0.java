import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 동전의 개수
		int K = Integer.parseInt(st.nextToken()); // 동전의 값;
		Integer coin[] = new Integer[N]; // 동전들 갯수들
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(coin, Comparator.reverseOrder()); // 내림차순
		for(int i = 0; i < N; i++) {
			if(coin[i] <= K) {
				cnt += K / coin[i];
				K %= coin[i];
			}
		}
		System.out.println(cnt);
	}

}
