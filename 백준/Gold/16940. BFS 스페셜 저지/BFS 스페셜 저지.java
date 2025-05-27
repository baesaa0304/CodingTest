import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Integer>[] graph; // 그래프 인접 리스트
    static int[] inputOrder;      // 입력으로 주어진 방문 순서

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 인접 리스트 초기화
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 입력
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        // 방문 순서 입력
        inputOrder = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inputOrder[i] = Integer.parseInt(st.nextToken());
        }

        // 방문 순서가 BFS 순서로 가능한지 확인
        System.out.println(isValidBFS() ? 1 : 0);
    }

    static boolean isValidBFS() {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();

        // 시작 노드는 1이어야 함
        if (inputOrder[0] != 1) return false;

        visited[1] = true;
        queue.offer(1);

        int idx = 1; // inputOrder의 다음 인덱스를 가리킴

        while (!queue.isEmpty()) {
            int current = queue.poll();
            Set<Integer> nextSet = new HashSet<>();

            // 현재 노드에서 방문할 수 있는 이웃들을 먼저 찾음
            for (int neighbor : graph[current]) {
                if (!visited[neighbor]) {
                    nextSet.add(neighbor);
                }
            }

            // 찾은 이웃들 중 inputOrder 순서대로 있는지 확인
            for (int i = 0; i < nextSet.size(); i++) {
                if (idx >= N || !nextSet.contains(inputOrder[idx])) {
                    return false;
                }
                visited[inputOrder[idx]] = true;
                queue.offer(inputOrder[idx]);
                idx++;
            }
        }

        return true;
    }
}