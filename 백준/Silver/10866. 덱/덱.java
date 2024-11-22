import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		Deque<Integer>dque = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> result = new ArrayList<>();
		
		int number = Integer.parseInt(br.readLine());
		for(int i = 0; i < number; i++) {
			String s = br.readLine();
			if(s.startsWith("push_front")) {
				dque.offerFirst(Integer.parseInt(s.split(" ")[1]));
			}
			else if(s.startsWith("push_back")) {
				dque.offerLast(Integer.parseInt(s.split(" ")[1]));
			}
			else if(s.equals("pop_front")) {
				if(dque.isEmpty()) {
					result.add(-1);
				}else {
					result.add(dque.pollFirst());
				}
				
				
			}
			else if(s.equals("pop_back")) {
				if(dque.isEmpty()) {
					result.add(-1);
				}else {
					result.add(dque.pollLast());
				}
			}
			else if(s.equals("size")) {
				result.add(dque.size());
			}
			else if(s.equals("empty")) {
				if(dque.isEmpty()) {
					result.add(1);
				}else {
					result.add(0);
				}
			}
			else if(s.equals("front")) {
				if(dque.isEmpty()) {
					result.add(-1);
				}
				else {
					result.add(dque.getFirst());
				}
				
			}
			else if(s.equals("back")) {
				if(dque.isEmpty()) {
					result.add(-1);
				}
				else {
					result.add(dque.getLast());
				}
				
			}
		}
		
		for(int i : result) {
			System.out.println(i);
		}

	}	

}
