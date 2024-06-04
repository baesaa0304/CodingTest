

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String yes = "( )";
		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			if(isValid(input)) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
			
		}
	}

	private static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }    
		}
		return stack.isEmpty();
	}

}
