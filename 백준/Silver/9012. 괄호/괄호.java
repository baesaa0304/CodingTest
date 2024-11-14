import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String gaho = br.readLine();
            Stack<Character> stack = new Stack<>();  // 스택을 매번 새로 초기화
            boolean isValid = true;

            for (Character c : gaho.toCharArray()) {
                if (c.equals('(')) {
                    stack.push(c);
                } else if (c.equals(')')) {
                    if (stack.isEmpty()) {
                        isValid = false;  // 스택이 비어있는데 ')'가 나오면 유효하지 않음
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }

            // 모든 괄호를 검사한 후 스택이 비어있고 유효하면 YES, 아니면 NO
            if (isValid && stack.isEmpty()) {
                result.add("YES");
            } else {
                result.add("NO");
            }
        }

        for (String s : result) {
            System.out.println(s);
        }
    }
} 