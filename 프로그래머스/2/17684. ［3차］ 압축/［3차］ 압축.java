import java.util.*;

class Solution {
    public int[] solution(String msg) {
    	ArrayList<Integer> list = new ArrayList<>();
		HashMap<String, Integer> map = new HashMap<>();
		
		//알파벳을 넣음! 
		for(int i = 1; i < 27; i++) {
			char alpha = (char) (64+i);
			map.put(String.valueOf(alpha), i);
		}    
		
		// 단어를 처음부터 끝가지 확인 
		for(int i = 0; i < msg.length(); i++) {
			String key = msg.charAt(i) + ""; 
			int index = i + 1; // 다음 글자 인덱

			while(index <= msg.length()) {
				if(index == msg.length()) {
					list.add(map.get(msg.substring(i)));
					i = index;
					break;
				}

				String nextKey = msg.substring(i, index+1);

				if(map.containsKey(nextKey)) { 
					index++;
				} else { 
					key = msg.substring(i, index);
					list.add(map.get(key)); 
					map.put(nextKey, map.size()+1); 
					i = index-1;
					break;
				}
			}
		}

		int[] answer = new int[list.size()];
		for(int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}
}
