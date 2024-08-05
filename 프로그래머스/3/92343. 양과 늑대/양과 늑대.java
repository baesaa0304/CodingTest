import java.util.*;


class Solution {
    // map 변수
    static ArrayList<ArrayList<Integer>> map = new ArrayList<ArrayList<Integer>>();

    // 양의 수 
    static int result = 0;

    // 각 노드의 양/늑대 구별
    static int[] node;

	// DFS
	// num : 현재 노드 인덱스 
	// sheep : 양의 수
	// wolf : 늑대의 수 
	// visit : 방문체크 변수 (true : 방문 O, false : 방문 X)
    public static void DFS(int num, int sheep, int wolf, boolean[] visit) {
        // 양이면 양의 수 추가 
        if(node[num] == 0) {
            sheep++;
        }
        
        // 늑대라면 늑대의 수 추가 
        else if(node[num] == 1) {
            wolf++;
        }
        
        // 늑대가 양보다 많거나 같을 경우 종료 
        if(wolf>=sheep) {
            return;
        }

        // 방문체크용 배열을 깊은 복사(주소가 아닌 값 복사)
        boolean[] newList = visit.clone();
        newList[num] = true;
        
        // 기록된 양의 최대 수 보다 많을 경우 갱신 
        result = Math.max(result, sheep);

        for(int i=0; i<newList.length; i++) {
            // 방문한 노드에서 갈 수 있는 곳 확인 
            if(newList[i] == true) {
                // 방문한 노드와 인접한 노드 체크 
                for(int j=0; j<map.get(i).size(); j++) {
                    int temp = map.get(i).get(j);

                    // 이미 갔던 곳은 안 가도록(새로운 곳만) 
                    if(newList[temp] == false) {
                        DFS(temp, sheep, wolf, newList);
                    }
                }
            }
        }
    }

    public int solution(int[] info, int[][] edges) {
         
		// 방문 체크용 변수
        boolean[] visited = new boolean[info.length];

        // 전역변수로 사용하기 위해 복사(얕은 복사해도 상관 없음)
        node = info;

        // map 설정
        for(int i=0; i<info.length; i++) {
            map.add(new ArrayList<Integer>());
        }

        // map 설정 ( 한쪽으로만 갈 수 있는 게 아니라 양방향으로 이동 가능하기 때문에 아래와 같이 설정 
        for(int i=0; i<edges.length; i++) {
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }

        // 양의 최대 수 구하기 
        DFS(0,0,0, visited);

        // 양의 최대 수 반환
        return result;
    }
}

