import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int Mut = 1;
		int Fac = 1;
		for(int i = 2; i <= Math.min(A, B); i++) {
			while(A % i == 0 && B % i == 0 ) {
				Mut *= i;
				A /= i;
                B /= i;
			}
		}
		Fac = A * B * Mut;
		System.out.println(Mut);
		System.out.println(Fac);

	}

}