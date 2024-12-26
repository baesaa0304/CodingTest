import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); 
        int B = Integer.parseInt(st.nextToken()); 
        StringBuilder sb = new StringBuilder();

        while (N > 0) {
            int number = N % B;
            if (number < 10) {
                sb.append(number);
            } else {
                sb.append((char) ('A' + (number - 10))); // 수정된 부분
            }
            N /= B;
        }
       
        System.out.println(sb.reverse().toString());
    }

}
