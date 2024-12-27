import java.io.*;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        BigInteger result = BigInteger.ONE;
        
        for (int i = 1; i <= N; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        String number = result.toString();
        int count = 0;

        // 끝에서부터 0의 개수 세기
        for (int i = number.length() - 1; i >= 0; i--) {
            if (number.charAt(i) == '0') {
                count++;
            } else{
                break;
            } 
        }

        System.out.println(count);
    }
}