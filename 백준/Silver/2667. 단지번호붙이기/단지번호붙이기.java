import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int count = 1;
	static int[][] map;
	static boolean[][] visit;
	static ArrayList<Integer> result = new ArrayList<>();
	static void dfs(int x, int y) {
		visit[x][y] = true; // 방문했음!
		
		if (y < map.length-1 && map[x][y+1]== 1 && !visit[x][y+1]) {
			count ++;
			dfs(x, y+1);
		}
		if(x <map.length-1 && map[x+1][y]== 1 && !visit[x+1][y]) {
			count++;
			dfs(x+1,y);
		}
		if(y >0 && map[x][y-1] == 1 && !visit[x][y-1]) {
			count ++;
			dfs(x,y-1);
		}
		if(x > 0 &&map[x-1][y] == 1 && !visit[x-1][y]) {
			count ++;
			dfs(x-1,y);
		}
	}
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 주어진 map크기를 입력받음
		map = new int [N][N]; // 아파트 단지 크기
		visit = new boolean[N][N]; // 방문
		
		for(int i =0; i < N; i++) {
			String row = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] =row.charAt(j)-'0';
			}
		}
		for(int i =0; i< map.length; i++) {
			for(int j = 0; j<map[i].length; j++) {
				if(map[i][j] == 1 && !visit[i][j]) {
					count = 1;
					dfs(i,j);
					result.add(count);
				}
			}
		}
		System.out.println(result.size());
		Collections.sort(result);
		for(int i =0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
	

}
