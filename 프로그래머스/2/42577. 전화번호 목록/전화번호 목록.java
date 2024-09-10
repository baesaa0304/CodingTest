import java.util.HashMap;

class Solution {
    public boolean solution(String[] phone_book) {
        HashMap<String, Boolean> hashmap = new HashMap<>(); 
        for(String phone : phone_book) {
        	hashmap.put(phone, true);
        }
        for(String phone : phone_book) {
        	for(int i = 1; i < phone.length(); i++) {
        		String s = phone.substring(0 , i);
        		if(hashmap.containsKey(s)) {
        			return false;
        		}
        	}
        }
        
        return true;
    }
}