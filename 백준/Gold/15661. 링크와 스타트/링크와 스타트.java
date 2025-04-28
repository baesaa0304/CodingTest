import java.io.*;
import java.util.*;

public class Main {
    static int[][] map; // 능력치 저장
    static int n;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution(n));
    }

    public static int solution(int n) {
        // 모든 조합을 만들어야 한다
        boolean[] visited = new boolean[n];
        dfs(0, visited);

        return min;
    }

    public static void dfs(int depth, boolean[] visited) {
        if (depth >= 1) { // 팀은 최소 1명 이상이어야 함
            calc(visited);
        }

        for (int i = depth; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, visited);
                visited[i] = false;
            }
        }
    }

    public static void calc(boolean[] visited) {
        List<Integer> team1 = new ArrayList<>();
        List<Integer> team2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (visited[i]) team1.add(i);
            else team2.add(i);
        }

        int team1Sum = 0;
        int team2Sum = 0;

        // 팀1 능력치 합
        for (int i = 0; i < team1.size(); i++) {
            for (int j = 0; j < team1.size(); j++) {
                if (i == j) continue;
                team1Sum += map[team1.get(i)][team1.get(j)];
            }
        }

        // 팀2 능력치 합
        for (int i = 0; i < team2.size(); i++) {
            for (int j = 0; j < team2.size(); j++) {
                if (i == j) continue;
                team2Sum += map[team2.get(i)][team2.get(j)];
            }
        }

        min = Math.min(min, Math.abs(team1Sum - team2Sum));
    }
}