import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int meeting [][] = new int[N][2];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			meeting[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
			meeting[i][1] = Integer.parseInt(st.nextToken()); // 종료 시간
		}
		Arrays.sort(meeting, new Comparator<int[]>() { // 2차원 정렬
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1])
					return o1[0] - o2[0];
				return o1[1] - o2[1];
			}
		});
		 
		int time = 0; // 그리디 최대 회의 수 구하기
		int end = 0; // 회의가 끝나는 시간
		
		for(int i = 0 ; i < N ;i++) { 
			if(end <= meeting[i][0]) { // 회의가 끝나는 시간이 같거나 크다면
				time++; // 횟수 +1
			end = meeting[i][1]; // end에 회의 끝나는 시간을 넣어줌
			}
		}

		System.out.println(time);
	}

}
