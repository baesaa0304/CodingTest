import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // 최대공약수 (GCD) 계산
            int gcd = gcd(N, M);

            // 최소공배수는 (N * M) / GCD
            int lcm = (N * M) / gcd;
            result.add(lcm); // 최소공배수 계산 후 결과 리스트에 추가
        }

        // 결과 출력
        for (int i : result) {
            System.out.println(i);
        }
    }

    // 최대공약수 (GCD) 계산
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}