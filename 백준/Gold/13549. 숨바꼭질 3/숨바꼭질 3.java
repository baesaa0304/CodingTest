

import java.util.*;
import java.io.*;

public class Main {
    static int subin, brother;
    static int[] arr = new int[100001];
    static boolean[] visit = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        subin = Integer.parseInt(st.nextToken());
        brother = Integer.parseInt(st.nextToken());

        bfs(subin);
        System.out.println(arr[brother]);
    }

    private static void bfs(int start) {
        Deque<Integer> deque = new LinkedList<>();
        deque.offer(start);
        visit[start] = true;

        while (!deque.isEmpty()) {
            int location = deque.poll();

            if (location == brother) {
                return;
            }

            // 순간이동 먼저 처리
            if (location * 2 <= 100000 && !visit[location * 2]) {
                deque.addFirst(location * 2);
                visit[location * 2] = true;
                arr[location * 2] = arr[location];
            }

            // 뒤로 이동
            if (location - 1 >= 0 && !visit[location - 1]) {
                deque.addLast(location - 1);
                visit[location - 1] = true;
                arr[location - 1] = arr[location] + 1;
            }

            // 앞으로 이동
            if (location + 1 <= 100000 && !visit[location + 1]) {
                deque.addLast(location + 1);
                visit[location + 1] = true;
                arr[location + 1] = arr[location] + 1;
            }
        }
    }
}
