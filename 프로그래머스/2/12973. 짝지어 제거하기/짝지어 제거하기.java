import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 1;
        Stack<Character>stack = new Stack<Character>();
		for(char c : s.toCharArray()){
			if(stack.isEmpty()) {
				stack.push(c);
			}
			else if(c == stack.peek()) {
				stack.pop();
			}
			else {
				stack.push(c);
			}
		}
		if(!stack.isEmpty()) {
			return 0;
		}
        return answer;
    }
}