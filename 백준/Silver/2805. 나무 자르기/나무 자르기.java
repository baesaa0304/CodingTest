import java.util.*;
import java.io.*;


public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 나무의 개수
		int M = Integer.parseInt(st.nextToken()); // 가져가야할 나무 수 길이
		int[] trees = new int[N];
		StringTokenizer truckTokenizer = new StringTokenizer(br.readLine());
		int max_tree = 0; // 나무들 중 가장 큰 나무
		int min_tree = 0;
		int result = 0; // 가져가야 최대값 나무
		for (int i =0; i < N; i++) {
			trees[i] = Integer.parseInt(truckTokenizer.nextToken()); // 현재 있는 나무들
			max_tree = Math.max(max_tree, trees[i]);
		}
		
		while(min_tree <= max_tree) {	
			int mid = (max_tree + min_tree) / 2; // 자를 나무의 높이를 정함.
			long cutTree = 0; // 자른 나무의 수
			
			for (int i = 0; i < trees.length; i++) {
					if(trees[i] > mid) {
						cutTree += (trees[i] - mid);
					}	
			 }
			 if (cutTree >= M) {
				 result = mid;
				 min_tree = mid + 1;
			} else {
				max_tree = mid - 1;
			}
		}
		System.out.println(result);
	}

}
