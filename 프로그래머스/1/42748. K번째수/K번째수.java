import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
    	int[] answer = new int [commands.length];
    	int idx = 0;
    	for(int i =0; i <commands.length; i++ ) {
    		int a = commands[i][0] - 1;
    		int b = commands[i][1];
    		int c = commands[i][2] - 1;
    		int[] arrs = new int[b - a];
    		int index = 0;
    		for(int j = a; j < b; j++) {
    			arrs[index++] = array[j];
    			//System.out.println(arrs[index]);
    			
    		}
    		Arrays.sort(arrs);
    		answer[idx++] = arrs[c];
    	}
        
        return answer;
    }
}