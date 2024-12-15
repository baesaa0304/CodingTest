import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;

        // 한 줄씩 입력받아 처리
        while ((line = br.readLine()) != null) {
            int lowerCount = 0;
            int upperCount = 0;
            int digitCount = 0;
            int spaceCount = 0;

            // 각 문자를 검사
            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);

                if (Character.isLowerCase(ch)) { // 소문자
                    lowerCount++;
                } else if (Character.isUpperCase(ch)) { // 대문자
                    upperCount++;
                } else if (Character.isDigit(ch)) { // 숫자
                    digitCount++;
                } else if (Character.isWhitespace(ch)) { // 공백
                    spaceCount++;
                }
            }

            // 결과 출력
            System.out.println(lowerCount + " " + upperCount + " " + digitCount + " " + spaceCount);
        }
    }
}