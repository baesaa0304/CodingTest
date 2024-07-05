import java.util.*;

class Solution {
	boolean solution(String s) {
		boolean answer = true;
		Stack<Character>stack = new Stack<>();
		for(char bracket : s.toCharArray()) {
			if(bracket == '(') {
				stack.push(bracket);
			}
			else if(bracket == ')') {
				if(stack.isEmpty()) {
					return false;
				}
				stack.pop();
			}
		}
		if(stack.isEmpty()) {
			return answer;
		}else {
			return false;
		}
        
    }
	
}