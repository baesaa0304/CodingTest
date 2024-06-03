

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 
 
		for(int i = 0; i < T; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken()); // 문서의 개
			int M = Integer.parseInt(st.nextToken()); // 원하는 문서의 위치 
			
			Queue<int[]> que = new LinkedList<>();	
			st = new StringTokenizer(br.readLine());
 
			for (int j = 0; j < N; j++) {
				que.offer(new int[] { j, Integer.parseInt(st.nextToken()) }); // 각 문서들을 넣어줌 1, 2, 3, 4...
			}
 
			int count = 0;	// 출력 횟수
			
			while (!que.isEmpty()) {	// 한 케이스에 대한 반복문
				int [] temp = que.poll();
				boolean check = true;
				// 큐를 순회하면서 중요도 비교
				for(int []document : que) {
					if(temp[1] < document[1]) {
						que.offer(temp);
						check = false;
						break;
					}
				}
				if(check) {
					count ++;
					if(temp[0] == M) {
						sb.append(count).append('\n');
						break;
					}
				}
			}
		}
		System.out.println(sb);
	}
 
}
