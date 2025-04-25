import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[] visited;
    static int N;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combination(0, 0);
        System.out.println(min);
    }

    // 팀 나누기 조합
    public static void combination(int depth, int start) {
        if (depth == N / 2) {
            calculate();
            return;
        }

        for (int i = start; i < N; i++) {
            visited[i] = true;
            combination(depth + 1, i + 1);
            visited[i] = false;
        }
    }

    // 능력치 계산
    public static void calculate() {
        int startTeam = 0;
        int linkTeam = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    startTeam += map[i][j] + map[j][i];
                } else if (!visited[i] && !visited[j]) {
                    linkTeam += map[i][j] + map[j][i];
                }
            }
        }

        int diff = Math.abs(startTeam - linkTeam);
        min = Math.min(min, diff);
    }
}
