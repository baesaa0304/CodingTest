import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		List<Integer> result = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			String q = st.nextToken();
			
			if(q.equals("push")) {
				int c = Integer.parseInt(st.nextToken());
				queue.add(c);
			}
			
			else if(q.equals("pop")) {
				if(queue.isEmpty()) {
					result.add(-1);
				}
				else {
					result.add(queue.poll());
					
				}
			}
			
			else if(q.equals("size")) {
				result.add(queue.size());
			}
			
			else if(q.equals("empty")) {
				if(queue.isEmpty()) {
					result.add(1);
				}
				else {
					result.add(0);
				}
			}
			
			else if(q.equals("front")) {
				if(queue.isEmpty()) {
					result.add(-1);
				}
				else {
					result.add(queue.peek());
				}
			}
			
			else if(q.equals("back")) {
				if(queue.isEmpty()) {
					result.add(-1);
				}
				else {
					result.add(((LinkedList<Integer>) queue).peekLast());
				}
			}
			
		}
		for(int i : result) {
			System.out.println(i);
		}

	}

}
