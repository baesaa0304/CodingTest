import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int O = Integer.parseInt(br.readLine());
		int sumS = N + M + O;
		if(N == 60 && M == 60 && O ==60) {
			System.out.println("Equilateral");
		}
		else if(sumS == 180) {
			if( N == M || N == O || M == O) {
				System.out.println("Isosceles");
			} else {
				System.out.println("Scalene");
			}
		}else {
			System.out.println("Error");
		}
	}

}
