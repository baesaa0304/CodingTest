

import java.util.*;
import java.io.*;

public class Main {
    static int subin, brother;
    static int[] arr = new int[100001];
    static int[] cases = new int[100001];
    static boolean[] visit = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        subin = Integer.parseInt(st.nextToken());
        brother = Integer.parseInt(st.nextToken());

        bfs(subin);

        System.out.println(arr[brother]);
        System.out.println(cases[brother]);
    }

    private static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        visit[start] = true;
        arr[start] = 0; // 시작 위치의 시간은 0초
        cases[start] = 1; // 시작 위치에 도달하는 경로의 수는 1

        while (!que.isEmpty()) {
            int location = que.poll();

            if (location == brother) {
                continue; // 동생의 위치에 도달했더라도 계속 탐색하여 모든 경로의 수를 계산
            }

            int back = location - 1;
            int front = location + 1;
            int tele = location * 2;

            int[] nextLocations = {back, front, tele};

            for (int next : nextLocations) {
                if (next >= 0 && next <= 100000) {
                    if (!visit[next]) {
                        que.offer(next);
                        visit[next] = true;
                        arr[next] = arr[location] + 1;
                        cases[next] = cases[location]; // 새로운 위치에 도달하는 경로의 수 초기화
                    } else if (arr[next] == arr[location] + 1) {
                        cases[next] += cases[location]; // 이미 방문한 위치지만 최단 시간으로 도달한 경우 경로의 수를 누적
                    }
                }
            }
        }
    }
}
