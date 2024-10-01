import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int train[] = new int[10];
		int people = 0;
		int result = 0;
		for(int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int gets_in = Integer.parseInt(st.nextToken());
			int gets_out = Integer.parseInt(st.nextToken());
			people = people - gets_in + gets_out;
			train[i] = people;
		}
		for(int i : train) {
			if(result < i) {
				result = i;
			}
		}
		System.out.println(result);

	}

}
