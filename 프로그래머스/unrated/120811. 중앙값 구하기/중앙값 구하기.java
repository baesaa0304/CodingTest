import java.util.Arrays;

class Solution {
    public int solution(int[] array) {
      
        Arrays.sort(array);  // 배열을 오름차순으로 정렬
        int answer = array[array.length/2];
         return answer;
            
        }
      
    }
