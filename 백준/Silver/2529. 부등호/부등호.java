
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[] sign;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();
    static String maxAnswer = "";
    static String minAnswer = "";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sign = new char[N];
        visit = new boolean[10]; // 0~9 숫자 사용 여부

        String line = br.readLine();
        line = line.replaceAll(" ", ""); // 공백 다 제거
        sign = line.toCharArray(); // 문자 하나하나 배열로 저장

     // 먼저 큰 숫자부터 dfs 해서 maxAnswer 찾기
        dfs(0, "", true);

        // visit 배열 초기화
        visit = new boolean[10];

        // 작은 숫자부터 dfs 해서 minAnswer 찾기
        dfs(0, "", false);

        // 결과 출력
        System.out.println(maxAnswer);
        System.out.println(minAnswer);
    }

    

	public static void dfs(int depth, String num, boolean isMax) {
	    if (depth == N + 1) {
	        if (isMax) maxAnswer = num;
	        else minAnswer = num;
	        return;
	    }
	
		    if (isMax) { // 최댓값 찾을 때는 9 -> 0
		        for (int i = 9; i >= 0; i--) {
		            if (!visit[i]) {
		                if (depth == 0 || check(num.charAt(depth - 1) - '0', i, sign[depth - 1])) {
		                    visit[i] = true;
		                    dfs(depth + 1, num + i, isMax);
		                    visit[i] = false;
		                    if (maxAnswer.length() != 0) return; // 최댓값 찾았으면 바로 return
		                }
		            }
		        }
		    } else { // 최솟값 찾을 때는 0 -> 9
		        for (int i = 0; i <= 9; i++) {
		            if (!visit[i]) {
		                if (depth == 0 || check(num.charAt(depth - 1) - '0', i, sign[depth - 1])) {
		                    visit[i] = true;
		                    dfs(depth + 1, num + i, isMax);
		                    visit[i] = false;
		                    if (minAnswer.length() != 0) return; // 최솟값 찾았으면 바로 return
		                }
		            }
		        }
		    }
		}

	public static boolean check(int a, int b, char op) {
	    if (op == '<') return a < b;
	    else return a > b;
	}
}
