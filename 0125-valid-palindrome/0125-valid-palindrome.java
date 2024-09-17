class Solution {
    public boolean isPalindrome(String s) {
    	String onlyLetters = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    	StringBuffer word = new StringBuffer(onlyLetters);
        String reverse_word = word.reverse().toString();
        if(reverse_word.equals(onlyLetters)) {
        	return true;
        }
        return false;
    }
}