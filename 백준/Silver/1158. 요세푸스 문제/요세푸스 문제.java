import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        Queue<Integer>que = new LinkedList<>();
        
        for (int i = 1; i < N + 1; i++) {
        	que.offer(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        
        while(que.size() !=  1) {
        	for(int i = 0; i < M - 1; i++) {
            	que.offer(que.poll());
            } 
        	sb.append(que.poll()).append(", ");
        } 
      sb.append(que.poll()).append(">");
      System.out.println(sb);
	}
	
}
