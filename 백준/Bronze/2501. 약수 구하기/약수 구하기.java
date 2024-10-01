import java.io.*;
import java.util.*;

public class Main  {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		ArrayList<Integer> measure = new ArrayList<>();
		
		for(int i = 1; i <=N; i++) {
			if(N % i == 0) {
				measure.add(i);
			}
		}
		// K번째 약수가 존재하는지 확인
        if(K <= measure.size()) {
            System.out.println(measure.get(K-1));  
        } else {
            System.out.println(0);  
        }
	}
	
	
}
