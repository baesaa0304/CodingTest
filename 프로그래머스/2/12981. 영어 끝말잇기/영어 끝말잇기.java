import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0 , 0};
        HashSet<String>wordSet = new HashSet<>();
        for(int i = 0; i < words.length; i++) {
        	if(i > 0) {
        		String s1 = words[i -1];
            	String s2 = words[i];
            	
            	char last = s1.charAt(s1.length() -1);
            	char now = s2.charAt(0);
            	if(last != now || wordSet.contains(s2)) {
            		answer[0] = (i % n) + 1; // 플레이어 번호 (1부터 시작)
                    answer[1] = (i / n) + 1; // 턴 번호
                    return answer;
            	}
        	}
        	 wordSet.add(words[i]);
        	
        }
        return answer;
    }
}