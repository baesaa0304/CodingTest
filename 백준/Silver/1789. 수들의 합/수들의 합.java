
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long S = Long.parseLong(br.readLine());
		long sum = 0; // 자연수 들의 합 
		int max_number = 0; // 가장 큰 자연수 -> 우리가 찾아야 할 값 
		for(int i = 1; i< Integer.MAX_VALUE ; i++) { // 자연수는 1부터 시작 
			sum+= i;
			if(sum > S) { // S를 넘으면 종료 
				break;
			}
			max_number = i;
		}
		System.out.println(max_number);

	}

}
