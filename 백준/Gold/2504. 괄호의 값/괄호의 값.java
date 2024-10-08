import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String parentheses = br.readLine();
        Stack<Character> stack = new Stack<>();
        int result = 0;
        int tmp = 1;  

        for (int i = 0; i < parentheses.length(); i++) {
            char c = parentheses.charAt(i);

            // 열린 괄호일 경우
            if (c == '(') {
                stack.push(c);
                tmp *= 2;  // '('가 열리면 임시 값은 2배
            } else if (c == '[') {
                stack.push(c);
                tmp *= 3;  // '['가 열리면 임시 값은 3배
            }
            // 닫힌 괄호 ')' 일 경우
            else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {  // 짝이 맞지 않는 경우
                    System.out.println(0);
                    return;
                }
                if (parentheses.charAt(i - 1) == '(') {  // 바로 앞에 '('가 있으면
                    result += tmp; 
                }
                stack.pop();
                tmp /= 2;  
            }
            // 닫힌 괄호 ']' 일 경우
            else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {  
                    System.out.println(0);
                    return;
                }
                if (parentheses.charAt(i - 1) == '[') { 
                    result += tmp; 
                }
                stack.pop();
                tmp /= 3;  
            }
        }

        // 스택이 비어 있지 않으면 짝이 맞지 않는 것이므로 0 출력
        if (!stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }
    }
}
