import java.io.*;
import java.util.*;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        // 스택 2개를 사용하여 문제 해결
        Stack<Character> leftStack = new Stack<>();  // 커서 왼쪽 부분을 저장
        Stack<Character> rightStack = new Stack<>(); // 커서 오른쪽 부분을 저장

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 초기 문자열을 입력받아 왼쪽 스택에 넣음
        String word = br.readLine();
        for (char c : word.toCharArray()) {
            leftStack.push(c);
        }
        
        // 명령의 개수 입력
        int num = Integer.parseInt(br.readLine());

        // 명령어 처리
        for (int i = 0; i < num; i++) {
            String command = br.readLine();

            // 명령어가 'P x'인 경우 처리
            if (command.startsWith("P")) {
                char x = command.charAt(2); // 'P ' 다음의 문자를 얻어옴
                leftStack.push(x);          // 커서 왼쪽에 문자를 추가
            } 
            // 명령어가 'L'인 경우 처리 (왼쪽으로 커서 이동)
            else if (command.equals("L")) {
                if (!leftStack.isEmpty()) {
                    rightStack.push(leftStack.pop()); // 왼쪽 스택에서 오른쪽 스택으로 이동
                }
            } 
            // 명령어가 'D'인 경우 처리 (오른쪽으로 커서 이동)
            else if (command.equals("D")) {
                if (!rightStack.isEmpty()) {
                    leftStack.push(rightStack.pop()); // 오른쪽 스택에서 왼쪽 스택으로 이동
                }
            } 
            // 명령어가 'B'인 경우 처리 (왼쪽 문자 삭제)
            else if (command.equals("B")) {
                if (!leftStack.isEmpty()) {
                    leftStack.pop(); // 왼쪽 스택에서 문자 삭제
                }
            }
        }

        // 왼쪽 스택과 오른쪽 스택을 모두 출력해야 함
        // 먼저 왼쪽 스택에 있는 문자들을 출력하고, 그 후 오른쪽 스택을 역순으로 출력
        StringBuilder sb = new StringBuilder();
        for (char c : leftStack) {
            sb.append(c);
        }
        while (!rightStack.isEmpty()) {
            sb.append(rightStack.pop());
        }

        // 최종 출력
        System.out.println(sb.toString());
    }
}