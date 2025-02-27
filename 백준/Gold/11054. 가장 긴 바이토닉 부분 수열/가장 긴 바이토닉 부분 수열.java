import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(solution(N, arr));

	}
	public static int  solution(int n , int arr[]) {
		int[] increase = new int[n]; // LIS (왼쪽에서 오른쪽)
        int[] decrease = new int[n]; // LIS (오른쪽에서 왼쪽)

        Arrays.fill(increase, 1);
        Arrays.fill(decrease, 1);


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    increase[i] = Math.max(increase[i], increase[j] + 1);
                }
            }
        }

  
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (arr[j] < arr[i]) {
                    decrease[i] = Math.max(decrease[i], decrease[j] + 1);
                }
            }
        }


        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            maxLength = Math.max(maxLength, increase[i] + decrease[i] - 1);
        }

        return maxLength;
    }
}