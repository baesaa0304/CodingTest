import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> result = new ArrayList<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = N; i <= M; i++) {
            if (i == 1) { // 1은 소수가 아님
                continue;
            }

            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) { // 제곱근까지만 검사
                if (i % j == 0) {
                    isPrime = false;
                    break; // 약수가 존재하면 소수가 아님
                }
            }

            if (isPrime) {
                result.add(i); // 소수인 경우 리스트에 추가
            }
        }

        for (int s : result) {
            System.out.println(s); // 소수를 출력
        }
    }
}