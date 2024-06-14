

import java.util.*;
import java.io.*;

public class Main {
    
    static StringBuilder sb = new StringBuilder();
    static boolean[] visit;
    static int[] lotto;
    static int K;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            if (K == 0) break;
            lotto = new int[K];
            visit = new boolean[K];
            for(int i = 0; i < K; i++) {
                lotto[i] = Integer.parseInt(st.nextToken());
            }
            DFS(0, 0);
            System.out.println(); // 각 테스트 케이스 사이에 빈 줄 출력
        }
    }

    private static void DFS(int depth, int start) {
        if(depth == 6) {
            for(int i = 0; i < K; i++) {
                if(visit[i]) {
                    System.out.print(lotto[i] + " ");
                }
            }
            System.out.println();
            return;
        }
        for (int i = start; i < K; i++) {
            visit[i] = true; // 방문 체크
            DFS(depth + 1, i + 1); // 재귀호출, 하나의 깊이를 탐색 
            visit[i] = false; // 초기화
        }
    }
}
