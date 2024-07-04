import java.util.*;

class Solution {
    public int solution(String dirs) {
        // 방향과 경계 설정
        int[] dx = {0, 0, -1, 1}; // 상(U), 하(D), 좌(L), 우(R)
        int[] dy = {1, -1, 0, 0};
        Map<Character, Integer> directionMap = new HashMap<>();
        directionMap.put('U', 0);
        directionMap.put('D', 1);
        directionMap.put('L', 2);
        directionMap.put('R', 3);
        
        Set<String> visitedPaths = new HashSet<>();
        int x = 0, y = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        
        // BFS 실행
        for (char dir : dirs.toCharArray()) {
            int[] current = queue.poll();
            x = current[0];
            y = current[1];
            
            int move = directionMap.get(dir);
            int nx = x + dx[move];
            int ny = y + dy[move];
            
            // 경계 체크
            if (nx >= -5 && nx <= 5 && ny >= -5 && ny <= 5) {
                // 경로 추가
                String path1 = x + "," + y + "," + nx + "," + ny;
                String path2 = nx + "," + ny + "," + x + "," + y;
                visitedPaths.add(path1);
                visitedPaths.add(path2);
                
                // 큐에 새로운 좌표 추가
                queue.offer(new int[]{nx, ny});
            } else {
                // 경계 벗어난 경우 큐에 다시 추가
                queue.offer(new int[]{x, y});
            }
        }
        
        // 고유 경로의 수 반환
        return visitedPaths.size() / 2;
    }
}