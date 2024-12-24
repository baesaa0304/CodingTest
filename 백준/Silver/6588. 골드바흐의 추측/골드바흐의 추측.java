import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 소수 판별 범위 설정
        int limit = 1000000; // 문제에서 최대 범위
        boolean[] isPrime = new boolean[limit + 1];

        // 에라토스테네스의 체로 소수 구하기
        for (int i = 2; i <= limit; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // 입력 처리 및 결과 출력
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break; // 입력이 0이면 종료

            boolean found = false;
            for (int i = 2; i <= n / 2; i++) {
                if (isPrime[i] && isPrime[n - i]) {
                    sb.append(n).append(" = ").append(i).append(" + ").append(n - i).append("\n");
                    found = true;
                    break;
                }
            }

            if (!found) {
                sb.append("Goldbach's conjecture is wrong.\n");
            }
        }

        System.out.println(sb.toString());
    }
}