import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static char[][] miro;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 이동을 위한 x 방향
    static int[] dy = {0, 0, -1, 1}; // 상하좌우 이동을 위한 y 방향
    static boolean lever = false;
    public int solution(String[] maps) {
        int answer = -1; 
        miro = new char[maps.length][maps[0].length()];
        visit = new boolean[maps.length][maps[0].length()];
        
        for (int i = 0; i < maps.length; i++) {
            miro[i] = maps[i].toCharArray();
        }
        
        int miro_x = 0, miro_y = 0;
        
        for (int i = 0; i < miro.length; i++) {
            for (int j = 0; j < miro[0].length; j++) {
                if (miro[i][j] == 'S') {
                    miro_x = i;
                    miro_y = j;
                }
            }
        }
        
        // BFS 결과를 answer에 할당
        answer = BFS(miro_x, miro_y);
        return answer;
    }

    public static int BFS(int x, int y) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{x, y, 0});
        visit[x][y] = true;
        
        while (!que.isEmpty()) {
            int[] poll = que.poll();
            int PX = poll[0];
            int PY = poll[1];
            int time = poll[2];
            /**
             * 레버 설정을 안 해
             */
            if(!lever && miro[PX][PY] == 'L') {
            	visit = new boolean [miro.length][miro[0].length];
            	que.clear();
            	que.add(new int[]{PX , PY , time});
            	visit[PX][PY] = true;
            	lever = true;
            } else if (lever && miro[PX][PY] == 'E') {
                return time;
            }
            for (int i = 0; i < 4; i++) {
                int next_x = dx[i] + PX;
                int next_y = dy[i] + PY;
                
                // 인덱스가 0 이상이고 배열의 크기보다 작아야 합니다.
                if (next_x >= 0 && next_x < miro.length && next_y >= 0 && next_y < miro[0].length) {
                    if (!visit[next_x][next_y] && miro[next_x][next_y] != 'X') {
                        visit[next_x][next_y] = true;
                        que.add(new int[]{next_x, next_y, time + 1});
                    }
                }
            }
        }
        
        return -1; // E에 도달하지 못한 경우
    }
}