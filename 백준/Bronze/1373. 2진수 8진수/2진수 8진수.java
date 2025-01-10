import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 2진수 입력 받기
        String binary = br.readLine();

        // 2진수를 10진수로 변환 (BigInteger 사용)
        BigInteger decimal = new BigInteger(binary, 2);

        // 10진수를 8진수 문자열로 변환
        String octal = decimal.toString(8);

        // 결과 출력
        System.out.println(octal);
    }
}