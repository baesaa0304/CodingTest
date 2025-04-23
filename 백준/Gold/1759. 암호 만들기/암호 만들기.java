

import java.io.*;
import java.util.*;

public class Main {
	 static int L, C;
	    static char[] input;
	    static boolean[] visited;
	    static StringBuilder sb = new StringBuilder();

	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());

	        L = Integer.parseInt(st.nextToken());
	        C = Integer.parseInt(st.nextToken());

	        input = new char[C];
	        visited = new boolean[C];

	        st = new StringTokenizer(br.readLine());
	        for (int i = 0; i < C; i++) {
	            input[i] = st.nextToken().charAt(0);
	        }

	        Arrays.sort(input); // 사전 순 정렬
	        solution(0, 0);
	        System.out.print(sb);
	    }

	    // start: 조합 시작 인덱스, depth: 선택한 문자 수
	    public static void solution(int start, int depth) {
	        if (depth == L) {
	            StringBuilder password = new StringBuilder();
	            int vowel = 0; // 모음이면 vowel++
	            int consonant = 0;  // 자음이면 consonant++

	            for (int i = 0; i < C; i++) {
	                if (visited[i]) {
	                    password.append(input[i]);
	                    if (isVowel(input[i])) vowel++;
	                    else consonant++;
	                }
	            }
	            //  만족하지 않으면 암호로 출력하지 않음
	            if (vowel >= 1 && consonant >= 2) {
	                sb.append(password).append("\n");
	            }
	            return;
	        }

	        for (int i = start; i < C; i++) {
	            visited[i] = true;
	            solution(i + 1, depth + 1);
	            visited[i] = false;
	        }
	    }
	    
	    // 문자가 모음인 확인
	    public static boolean isVowel(char c) {
	        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	    }

}
