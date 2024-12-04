import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String expression = reader.readLine();  // 사용자로부터 중위 표현식 입력 받기

        // 중위 표현식을 후위 표현식으로 변환
        String result = infixToPostfix(expression);

        // 후위 표현식 출력 (문구 없이 바로 출력)
        System.out.println(result);
    }

    // 중위 표현식을 후위 표현식으로 변환하는 메소드
    public static String infixToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        // 중위 표현식의 각 문자를 순차적으로 확인
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // 피연산자 (알파벳)일 경우 바로 결과에 추가
            if (Character.isLetter(c)) {
                result.append(c);
            }
            // '('는 스택에 넣기
            else if (c == '(') {
                stack.push(c);
            }
            // ')'는 '('가 나올 때까지 스택에서 꺼내서 결과에 추가
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop(); // '(' 제거
            }
            // 연산자일 경우
            else {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
                    result.append(stack.pop());
                }
                stack.push(c); // 연산자를 스택에 넣기
            }
        }

        // 스택에 남아있는 연산자들을 모두 결과에 추가
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    // 연산자의 우선순위를 반환하는 메소드
    public static int precedence(char op) {
        if (op == '+' || op == '-') {
            return 1;
        } else if (op == '*' || op == '/') {
            return 2;
        } else if (op == '^') {
            return 3;
        }
        return -1; // 연산자가 아닌 경우
    }
}