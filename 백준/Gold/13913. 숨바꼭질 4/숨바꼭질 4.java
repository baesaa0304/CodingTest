

import java.util.*;
import java.io.*;

public class Main {
    static int subin, brother;
    static int[] arr = new int[100001];
    static boolean[] visit = new boolean[100001];
    static int[] parent = new int[100001]; // 경로를 추적하기 위한 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        subin = Integer.parseInt(st.nextToken());
        brother = Integer.parseInt(st.nextToken());

        if (subin == brother) {
            System.out.println(0);
            System.out.println(subin);
        } else {
            bfs(subin);
            System.out.println(arr[brother]);
            printPath();
        }
    }

    private static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        visit[start] = true;
        arr[start] = 0;
        parent[start] = -1;

        while (!que.isEmpty()) {
            int location = que.poll();

            if (location == brother) {
                return; // 동생 위치에 도달하면 탐색 종료
            }

            int[] nextLocations = {location - 1, location + 1, location * 2};

            for (int next : nextLocations) {
                if (next >= 0 && next <= 100000) {
                    if (!visit[next]) {
                        que.offer(next);
                        visit[next] = true;
                        arr[next] = arr[location] + 1;
                        parent[next] = location; // 경로를 기록
                    }
                }
            }
        }
    }

    private static void printPath() {
        Stack<Integer> path = new Stack<>();
        int position = brother;
        while (position != -1) {
            path.push(position);
            position = parent[position];
        }

        StringBuilder sb = new StringBuilder();
        while (!path.isEmpty()) {
            sb.append(path.pop()).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}