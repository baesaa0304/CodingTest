import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args)throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int N = Integer.parseInt(br.readLine());
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 int test[] = new int[N];
		
		 int count = 0;
		 for(int i = 0; i < N; i++) {
			 test[i] = Integer.parseInt(st.nextToken());
		 }
		 for(int i : test) {
			if(i == 1) {
				continue;
			}
			 boolean isPrime = true;
			for(int j = 2; j*j <= i; j++) {
				if(i % j == 0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) {
				count++;
			}
		 }
		 System.out.println(count);
	}

}
