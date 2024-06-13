

import java.util.*;
import java.io.*;

public class Main {
	 public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int N = Integer.parseInt(br.readLine());
	     HashMap<Integer, Integer> cardmap = new HashMap<>();
	     StringTokenizer st = new StringTokenizer(br.readLine());
	     for (int i = 0; i < N; i++) {
	    	 	int card = Integer.parseInt(st.nextToken());
	    	 	cardmap.put(card, cardmap.getOrDefault(card, 0) + 1);
	        }
	     
	        int M = Integer.parseInt(br.readLine());
	        StringBuilder sb = new StringBuilder();
	        
	        st = new StringTokenizer(br.readLine());
	        for (int i = 0; i < M; i++) {
	            int key = Integer.parseInt(st.nextToken());
	            if (cardmap.containsKey(key)) {
	                sb.append(1).append("\n"); // 찾는 값이 해시맵에 존재할 경우 1 추가
	            } else {
	                sb.append(0).append("\n"); // 찾는 값이 해시맵에 존재하지 않을 경우 0 추가
	            }
	        }
	        
	        // 결과 출력
	        System.out.print(sb.toString());
	    }

}
