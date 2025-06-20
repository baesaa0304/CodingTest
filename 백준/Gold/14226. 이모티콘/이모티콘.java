import java.io.*;
import java.util.*;

public class Main {

    private static class State {
        int screen, clip, time;
        State(int screen, int clip, int time) {
            this.screen = screen;
            this.clip = clip;
            this.time  = time;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());   // 입력 한 줄
        int S = Integer.parseInt(st.nextToken());                  // 목표 이모티콘 수

        final int MAX = S * 2;                                     // 상태 공간 상한
        boolean[][] visited = new boolean[MAX + 1][MAX + 1];       // [화면][클립보드]

        Queue<State> q = new ArrayDeque<>();
        q.offer(new State(1, 0, 0));                               // 시작: 화면 1, 클립보드 0, 시간 0
        visited[1][0] = true;

        while (!q.isEmpty()) {
            State cur = q.poll();

            if (cur.screen == S) {                                 // 목표 달성
                System.out.println(cur.time);
                return;
            }

            // 1) 화면 전체 복사 → 클립보드
            if (!visited[cur.screen][cur.screen]) {
                visited[cur.screen][cur.screen] = true;
                q.offer(new State(cur.screen, cur.screen, cur.time + 1));
            }

            // 2) 클립보드 붙여넣기
            if (cur.clip > 0 && cur.screen + cur.clip <= MAX
                    && !visited[cur.screen + cur.clip][cur.clip]) {
                visited[cur.screen + cur.clip][cur.clip] = true;
                q.offer(new State(cur.screen + cur.clip, cur.clip, cur.time + 1));
            }

            // 3) 화면에서 하나 삭제
            if (cur.screen > 0 && !visited[cur.screen - 1][cur.clip]) {
                visited[cur.screen - 1][cur.clip] = true;
                q.offer(new State(cur.screen - 1, cur.clip, cur.time + 1));
            }
        }
    }
}