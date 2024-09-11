import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i : arr) {
        	if(!stack.isEmpty() && i == stack.peek()) {
        		continue;
        	}
        	else {
        		stack.add(i);
        	}
        }
        int[] answer = new int[stack.size()];
        int index = stack.size() - 1;
        while (!stack.isEmpty()) {
            answer[index--] = stack.pop();
        }
        return answer;
    }
}