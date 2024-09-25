

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();  
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());  // N 입력 받기
        int[] sequence = new int[N];  // 수열을 담을 배열
        
        // 수열 입력 받기
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(br.readLine());
        }

        int num = 1;  // 1부터 시작
        boolean possible = true;  // 가능한지 여부 판단

        for (int i = 0; i < N; i++) {
            int target = sequence[i];  // 현재 수열의 목표 값

            // 스택에 숫자를 목표 값에 도달할 때까지 넣는다.
            while (num <= target) {
                stack.push(num++);
                sb.append("+\n");  // push 했을 때는 + 추가
            }

            // 스택의 최상단이 목표 값과 같으면 pop
            if (stack.peek() == target) {
                stack.pop();
                sb.append("-\n");  // pop 했을 때는 - 추가
            } else {
                // 수열을 만들 수 없으면 "NO" 출력하고 종료
                possible = false;
                break;
            }
        }

        if (possible) {
            System.out.println(sb.toString());  // 가능한 경우 결과 출력
        } else {
            System.out.println("NO");  // 불가능한 경우 NO 출력
        }
    }
}