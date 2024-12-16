import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c >= 'A' && c <= 'Z') {  // 대문자 처리
                int change = (c - 'A' + 13) % 26 + 'A';  // 13글자 밀기
                sb.append((char) change);
            } 
            else if (c >= 'a' && c <= 'z') {  // 소문자 처리
                int change = (c - 'a' + 13) % 26 + 'a';  // 13글자 밀기
                sb.append((char) change);
            } 
            else {
                sb.append(c);  // 알파벳이 아닌 문자는 그대로 추가
            }
        }
        
        System.out.println(sb.toString());
    }
}