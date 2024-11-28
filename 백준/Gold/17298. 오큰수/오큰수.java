import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();  // 스택 선언
        
        int A = Integer.parseInt(br.readLine());
        int[] sequence = new int[A];  // 수열 저장
        int[] result = new int[A];    // 결과값 오큰수 저장 
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < A; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
            result[i] = -1;  // 기본값은 -1로 설정 (오큰수가 없을 경우)
        }
        
        // 오큰수 계산
        for (int i = 0; i < A; i++) {
            // 현재 값이 스택의 최상단 값보다 클 때
            while (!stack.isEmpty() && sequence[stack.peek()] < sequence[i]) {
                int idx = stack.pop();  // 오큰수를 찾은 인덱스
                result[idx] = sequence[i];  // 해당 인덱스의 오큰수를 현재 값으로 설정
            }
            
            stack.push(i);  // 현재 인덱스를 스택에 추가
        }
        
        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < A; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb.toString().trim());  // 한 번에 출력
    }
}