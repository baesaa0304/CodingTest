import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 피연산자의 개수
        String expression = br.readLine();      // 후위 표현식
        double[] values = new double[N];        // 각 변수에 대응하는 값 저장
        
        for (int i = 0; i < N; i++) {
            values[i] = Double.parseDouble(br.readLine()); // 각 피연산자 값
        }
        
        Stack<Double> stack = new Stack<>();    // 계산을 위한 스택
        
        for (char c : expression.toCharArray()) { // 후위 표기식 처리
            if (c >= 'A' && c <= 'Z') {          // 피연산자일 경우
                stack.push(values[c - 'A']);     // 'A'는 0번째 인덱스에 대응
            } else {                             // 연산자일 경우
                double b = stack.pop();          // 두 피연산자를 꺼냄
                double a = stack.pop();
                
                switch (c) {                     // 연산자에 따라 계산 수행
                    case '+':
                        stack.push(a + b);
                        break;
                    case '-':
                        stack.push(a - b);
                        break;
                    case '*':
                        stack.push(a * b);
                        break;
                    case '/':
                        stack.push(a / b);
                        break;
                }
            }
        }
        
        // 최종 계산 결과 출력 (소수점 둘째 자리까지 출력)
        System.out.printf("%.2f\n", stack.pop());
    }
}
