import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visited = new boolean[N + 1];

        backtracking(0, 0);
        System.out.print(sb);
    }

    static void backtracking(int depth, int prev) {
        if (depth == M) {
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            // 이미 사용됐거나, 이전 숫자보다 작으면 패스 (오름차순 유지)
            if (!visited[i] && i > prev) {
                visited[i] = true;
                arr[depth] = i;
                backtracking(depth + 1, i); // 현재 숫자를 prev로 전달
                visited[i] = false; // 백트래킹
            }
        }
    }
}