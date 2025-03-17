import java.io.*;
import java.util.*;


public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수 입력

        StringBuilder sb = new StringBuilder();
        for (int s = 0; s < T; s++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken()) - 1; // 1-based index → 0-based index
            int y = Integer.parseInt(st.nextToken()) - 1; // 1-based index → 0-based index

            sb.append(solution(M, N, x, y)).append("\n"); // solution() 결과 저장
        }
        System.out.print(sb.toString()); // 한 번에 출력하여 속도 개선
    }

    public static int solution(int M, int N, int x, int y) {
        for (int i = x; i < (M * N); i += M) { // M씩 증가하면서 y가 맞는지 확인
            if (i % N == y) {
            	//System.out.println("i = " + i);
            	//System.out.println("i + 1 = " + i + 1 );
                return i + 1; // 다시 1-based index로 변환하여 반환
            }
        }
        return -1; // 찾지 못한 경우
    }
}
