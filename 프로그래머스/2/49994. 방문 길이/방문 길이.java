import java.util.*;

class Solution {
    public int solution(String dirs) {
        int N = 11;
        int x = 5, y = 5; // 격자의 중앙에서 시작
        Set<String> visitedPaths = new HashSet<>();

        for (char dir : dirs.toCharArray()) {
            int nx = x, ny = y;
            if (dir == 'U' && x > 0) {
                nx--; // 위로 이동
            }
            else if (dir == 'D' && x < 10) {
                nx++; // 아래로 이동
            }
                
            else if (dir == 'L' && y > 0) {
                ny--; // 왼쪽으로 이동
            }
            else if (dir == 'R' && y < 10) {
                ny++; // 오른쪽으로 이동
            }

            if (nx != x || ny != y) { // 유효한 이동인 경우
                String path1 = x + "," + y + "," + nx + "," + ny;
                String path2 = nx + "," + ny + "," + x + "," + y;
                visitedPaths.add(path1); // 경로 추가
                visitedPaths.add(path2); // 반대 경로도 추가

                x = nx;
                y = ny;
            }
        }

        return visitedPaths.size() / 2; // 각 경로가 두 번 카운트되므로 절반으로 나눔
    }
}