

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder result = new StringBuilder();
            while (st.hasMoreTokens()) {
                String word = st.nextToken();
                StringBuffer sb = new StringBuffer(word);
                String reversedStr = sb.reverse().toString();
                result.append(reversedStr).append(" "); // 각 단어 뒤에 공백 추가
            }
            System.out.println(result.toString().trim()); // 마지막 공백 제거 후 출력
        }
	}

}
