import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		Queue<Integer> que = new LinkedList<>();
		int M = Integer.parseInt(st.nextToken()); // 총 인원
		int N = Integer.parseInt(st.nextToken()); // 빠지는 사람
		sb.append("<");
		for(int i = 1; i <= M; i++) {
			que.add(i);
		}
		while(!que.isEmpty()) {
			for(int i = 1; i < N; i++) {
				que.add(que.poll()); // 맨 앞 요소를 꺼내서 뒤로 보냄
			}
			sb.append(que.poll());
			if (!que.isEmpty()) {
                sb.append(", "); // 큐가 비어있지 않으면 쉼표 추가
            }
		}
		sb.append(">");
		System.out.println(sb.toString()); 
	}

}
