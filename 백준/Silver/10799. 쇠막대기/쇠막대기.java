import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		int result = 0;
		String s = br.readLine();
		for(int i  = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if(c.equals('(')) {
				stack.push(c);
			}
			else if(c.equals(')')) {
				stack.pop();
				if (s.charAt(i - 1) == '(') {
                    // 레이저일 때는 스택의 개수를 더해줌
                    result += stack.size();
                } else {
                    // 쇠막대기가 끝날 때마다 +1
                    result++;
                }
			}
		}
		System.out.println(result);

	}

}
