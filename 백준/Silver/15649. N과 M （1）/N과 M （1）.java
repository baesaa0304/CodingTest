import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[] visited; // 방문 체크 배열
    static int[] arr; // 선택한 숫자를 저장할 배열
    static StringBuilder sb = new StringBuilder(); // 출력 최적화를 위한 StringBuilder

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1]; // 1부터 N까지 사용
        arr = new int[M]; // 길이가 M인 배열

        backtracking(0); // 백트래킹 시작
        System.out.print(sb.toString()); // 모든 결과를 출력
    }

    static void backtracking(int depth) {
        if (depth == M) { // M개를 선택하면 출력
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" "); // 배열 요소를 StringBuilder에 추가
            }
            sb.append("\n"); // 한 줄 개행 추가
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) { // 아직 선택하지 않은 숫자인 경우
                visited[i] = true; // 방문 체크
                arr[depth] = i; // 현재 위치에 숫자 저장
                backtracking(depth + 1); // 재귀 호출
                visited[i] = false; // 백트래킹 (원상 복구)
            }
        }
    }
}