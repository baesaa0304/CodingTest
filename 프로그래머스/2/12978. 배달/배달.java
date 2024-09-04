import java.util.*;

class Solution {
    
    static List<List<Node>> arr;  // 인접 리스트
    static int dist[];  // 각 마을에 방문할 때 거리의 수
    
    public int solution(int N, int[][] road, int K) {
        arr = new ArrayList<>();
        
        // 각 마을에 대한 인접 리스트 초기화
        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }
        
        // 도로 정보 저장
        for (int[] r : road) {
            int u = r[0], v = r[1], w = r[2];
            arr.get(u).add(new Node(v, w));  // u에서 v로 가는 거리 w
            arr.get(v).add(new Node(u, w));  // v에서 u로 가는 거리 w
        }

        // BFS 실행
        dist = bfs(N);

        // 결과 계산
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                count++;
            }
        }

        return count;
    }

    // BFS 메서드
    private int[] bfs(int N) {
        dist = new int[N + 1];
        Arrays.fill(dist, 500001);  // 초기값 설정
        dist[1] = 0;  // 시작점(1번 마을)의 거리는 0

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (Node neighbor : arr.get(current)) {
                int newdist = dist[current] + neighbor.weight;
                if (newdist < dist[neighbor.index]) {  // 더 짧은 거리가 있으면
                    dist[neighbor.index] = newdist;
                    queue.offer(neighbor.index);
                }
            }
        }

        return dist;
    }
    
    // Node 클래스: 마을 번호와 해당 마을까지의 거리를 저장
    static class Node {
        int index;
        int weight;

        Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }
    }
}
