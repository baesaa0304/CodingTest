
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        int[] result = new int[26];  // 각 알파벳의 첫 등장 위치
        
        // 처음에는 모든 값이 -1로 설정되도록 함
        for (int i = 0; i < 26; i++) {
            result[i] = -1;
        }

        // 문자열을 순차적으로 탐색
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 'a';  // 'a'를 0으로, 'b'를 1로, ..., 'z'를 25로 매핑

            // 첫 등장 위치 기록
            if (result[index] == -1) {
                result[index] = i;
            }
        }

        // 알파벳 'a'부터 'z'까지의 첫 등장 위치 출력
        for (int i = 0; i < 26; i++) {
            System.out.print(result[i] + " ");  // 첫 등장 위치 출력
        }
  
    }
}