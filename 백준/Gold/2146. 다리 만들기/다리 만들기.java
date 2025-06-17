import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
	static int map[][];
	static boolean visited[][];
	static int min=Integer.MAX_VALUE;
	static int dy[] = {-1,1,0,0};
	static int dx[] = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb=new StringBuilder();

		int N=Integer.parseInt(br.readLine());

		map=new int[N][N];
		visited=new boolean[N][N];

		for(int i=0;i<map.length;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<map.length;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int number = 2;
		//각각의 섬들마다 번호를 붙여준다 (dfs를 사용). 섬의 번호는 2부터 시작
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map.length;j++) {
				if(map[i][j]==1) {
					dfs(i,j,number++);
				}
			}
		}
		
	
		
		

		//섬의 번호가 2이상이면 bfs를 통해서 다른 섬과의 거리를 구한다
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map.length;j++) {
				if(map[i][j]>1) {
					bfs(i,j,map[i][j]);
				}
			}
		}
		
		System.out.println(min);




	}
	public static void bfs(int y,int x,int number) {
		Queue<Integer[]> queue=new LinkedList<>();
		visited=new boolean[map.length][map.length];
		visited[y][x] = true;
		queue.add(new Integer[] {y,x,0});

		while(!queue.isEmpty()) {
			Integer temp[] = queue.poll();
			int nowY=temp[0];
			int nowX=temp[1];
			int count=temp[2];
			
			//현재 위치가 바다가 아니고, 탐색을 시작한 섬의 번호와 현재 번호가 다르다면
			//최솟값 갱신
			if(map[nowY][nowX]!=0&&map[nowY][nowX]!=number) 
				min=Math.min(min,count-1);
			//count가 최소이상이면, 굳이 탐색할 필요없음. 리턴
			if(count>min)
				return;

			for(int i=0;i<4;i++) {

				int nextY=nowY+dy[i];
				int nextX=nowX+dx[i];
				if(nextY<0||nextX<0||nextY>=map.length||nextX>=map.length)
					continue;
				//다음 번호가 현재 번호와 같다면,continue
				//(우리는 섬의 테두리만을 볼 것이다 ! 섬의 중간지점을 건너뛰기 위해서는 이 작업이 필요)
				//이 작업을 함으로써 다음 지점이 바다와 연결되어 있는 테두리만을 탐색할 수 있다.
				if(map[nextY][nextX]==number)
					continue;
				if(visited[nextY][nextX]) continue;
				
				queue.add(new Integer[] {nextY,nextX,count+1});
				visited[nextY][nextX]=true;
			}

		}



	}

	//다음 번호와 일치한다면, dfs를 계속해서 수행
	public static void dfs(int y,int x,int number) {
		visited[y][x]=true;
		map[y][x]=number;
		for(int i=0;i<4;i++) {
			int nextY=y+dy[i];
			int nextX=x+dx[i];
			if(nextY<0||nextX<0||nextX>=map.length||nextY>=map.length)
				continue;
			if(visited[nextY][nextX]==true||map[nextY][nextX]!=1)
				continue;

			dfs(nextY,nextX,number);
		}
	}

}