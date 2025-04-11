
import java.io.*;
import java.util.*;

public class Main {
	static int N;
    static int[] arr;
    static boolean[] visited;
    static int[] perm;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        // 빠른 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        visited = new boolean[N];
        perm = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backtrack(0);
        System.out.println(max);
    }

    // 순열 생성
    static void backtrack(int depth) {
        if (depth == N) {
            int sum = 0;
            for (int i = 0; i < N - 1; i++) {
                sum += Math.abs(perm[i] - perm[i + 1]);
            }
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                perm[depth] = arr[i];
                backtrack(depth + 1);
                visited[i] = false;
            }
        }
    }
}
