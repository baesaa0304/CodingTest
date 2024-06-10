

import java.util.*;
import java.io.*;

public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int Coordinates [] = new int[N];
		int Coordinates_sort [] = new int[N];
		Map<Integer, Integer> rankMap = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			Coordinates[i] = Integer.parseInt(st.nextToken());
			Coordinates_sort[i] = Coordinates[i];
		}
		Arrays.sort(Coordinates_sort);
		int rank = 0;
		for(int value : Coordinates_sort) {
			if(!rankMap.containsKey(value)) {
				rankMap.put(value, rank);
				rank++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int value : Coordinates) {
			sb.append(rankMap.get(value)).append(' ');
		}
		
		System.out.println(sb);
	}

}