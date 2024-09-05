import java.util.*;


class Solution {
	
	static int N ; //세로  
	static int M;  // 가로 
	static int arr[][];
	static boolean visit[][]; // 빙문 확인 
	static int [] dx = {-1, 1, 0, 0};
	static int [] dy = {0, 0, -1, 1};
	static int corner = 500; // 코너 값 
	static int straight = 100; // 직진 값 
	static int cost = Integer.MAX_VALUE; // 비용 
	
    public int solution(int[][] board) {
    	 N = board.length;
    	 M = board[0].length;
    	arr = board;
        visit = new boolean[N][M];
        int answer = BFS(0,0);
        return answer;
    }
    
	public int BFS(int x, int y) {
		Queue<int[]> que = new LinkedList<>();
		int costs[][][] = new int[N][M][4]; // 각 좌표에 비용을 저장하는 배열 
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				for(int k = 0; k < 4; k++) {
					costs[i][j][k] = Integer.MAX_VALUE;
				}
			}
		}
		for (int i = 0; i < 4; i++) {
            que.offer(new int[] { x, y, i, 0 }); // x좌표, y좌표, 방향, 현재까지의 비용
            costs[x][y][i] = 0;
        }
		while(!que.isEmpty()) {
			int poll[] = que.poll();
			int poll_x = poll[0];
			int poll_y = poll[1];
			int dir = poll[2]; // 이전 방향
            int curr_cost = poll[3];
            
            if(poll_x == N-1 && poll_y == M-1) {
				cost = Math.min(cost, curr_cost); // 목적지에 도달하면 최소 비용을 갱신
			}
            
			for(int i =0; i < 4; i++) {
				int next_x = poll_x + dx[i];
				int next_y = poll_y + dy[i];
				int new_cost = curr_cost;
				if(next_x >= 0 && next_x < N && next_y >= 0 && next_y < M) {
					if(arr[next_x][next_y] != 1) {
						if (i == dir) { // 같은 방향이면 직진 비용만 추가
                            new_cost += straight;
                        } else { // 방향이 바뀌면 코너 비용 추가
                            new_cost += straight + corner;
                        }

                        // 이전에 방문한 적이 없거나 더 적은 비용으로 방문할 수 있는 경우
                        if (new_cost < costs[next_x][next_y][i]) {
                            costs[next_x][next_y][i] = new_cost;
                            que.offer(new int[] { next_x, next_y, i, new_cost });
                        }
					}
				}
			}
			
		}
		return cost;
	}
}