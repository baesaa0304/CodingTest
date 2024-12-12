import java.io.*;
import java.util.*;

public class Main {

	 public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 List<String> result = new ArrayList<String>();
		 String s = br.readLine();
		 for(int i = 0; i < s.length(); i++) {
			 result.add(s.substring(i));
		 }
		 Collections.sort(result);
		 for(String baekjoon : result) {
			 System.out.println(baekjoon);
		 }
	}

}