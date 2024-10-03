import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> arrayList = new ArrayList<>();
		int result = 0;
		int start = Integer.parseInt(st.nextToken());
		int end =  Integer.parseInt(st.nextToken());
		for(int i = 1; arrayList.size() < end; i++) {
			for(int j = 0; j < i; j++) {
				arrayList.add(i);
				if (arrayList.size() == end) break; 
			}
		}
		for(int i = (start - 1); i < end; i++) {
			 result += arrayList.get(i);
		}
		System.out.println(result);
	}

}
