import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력: 동생의 수 N과 수빈의 위치 S
        int N = Integer.parseInt(st.nextToken()); // 동생의 수
        int S = Integer.parseInt(st.nextToken()); // 수빈의 위치

        // 거리 차이 배열
        int[] gcds = new int[N];

        // 동생들의 위치 입력 및 거리 차이 저장
        st = new StringTokenizer(br.readLine()); // 동생들의 위치를 한 줄로 입력받음
        for (int i = 0; i < N; i++) {
            int Ai = Integer.parseInt(st.nextToken()); // 동생의 위치
            gcds[i] = Math.abs(Ai - S); // 거리 차이 저장
        }

        // 배열의 GCD 계산
        int result = gcds[0];
        for (int i = 1; i < N; i++) {
            result = gcd(result, gcds[i]); // 현재 GCD와 다음 값을 계산
        }

        // 결과 출력
        System.out.println(result);
    }

    // 최대공약수를 계산하는 재귀 함수
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}