import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		long countTwo = countFactor(n, 2) - countFactor(m, 2) - countFactor(n - m, 2);
        long countFive = countFactor(n, 5) - countFactor(m, 5) - countFactor(n - m, 5);
        
        System.out.println(Math.min(countTwo, countFive));
	}
	public static long countFactor(long n, int factor) {
        long count = 0;
        while (n >= factor) {
            count += n / factor;
            n /= factor;
        }
        return count;
    }

}
