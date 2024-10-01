import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[9];
		int sum=0;

		for(int i=0;i<9;i++) {
			int n = Integer.parseInt(br.readLine()); 
			arr[i] = n; 
			sum += arr[i]; 
		}
		Arrays.sort(arr);
		int a=0,b=0;
        
		//왜? 안쪽 for문이 맨 마지막 값을 체크해줌
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(sum - arr[i] - arr[j] == 100) {
					a=i;
					b=j;
					break;
				}
			}
		}
		for(int i=0;i<arr.length;i++) {
			if(i!=a && i!=b) {
				System.out.println(arr[i]);
			}
		}
	}
}