import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
        // 입력받음 
        int[] result = new int[26];  
        
        // 문자열을 순차적으로 탐색
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 'a'; 
            result[index] ++;
        }
    
        for (int i = 0; i < 26; i++) {
            System.out.print(result[i] + " "); 
        }
  
    }

}
