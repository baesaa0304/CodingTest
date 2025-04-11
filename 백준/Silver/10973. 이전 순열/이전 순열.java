
import java.io.*;
import java.util.*;

public class Main {
	 public static void main(String[] args) throws IOException {
	        // 입력
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int N = Integer.parseInt(br.readLine());
	        int[] arr = new int[N];
	        
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        for (int i = 0; i < N; i++) {
	            arr[i] = Integer.parseInt(st.nextToken());
	        }

	        // 이전 순열 알고리즘
	        if (prevPermutation(arr)) {
	            for (int num : arr) {
	                System.out.print(num + " ");
	            }
	        } else {
	            System.out.println(-1);
	        }
	    }

	    // 이전 순열 구하는 함수
	    public static boolean prevPermutation(int[] arr) {
	        int i = arr.length - 1;

	        // 1. 뒤에서부터 오름차순이 깨지는 지점 찾기
	        while (i > 0 && arr[i - 1] <= arr[i]) {
	            i--;
	        }

	        if (i == 0) return false; // 이미 가장 첫 번째 순열

	        int j = arr.length - 1;

	        // 2. i-1보다 작은 가장 큰 값 찾기
	        while (arr[i - 1] <= arr[j]) {
	            j--;
	        }

	        // 3. swap
	        swap(arr, i - 1, j);

	        // 4. i 이후 부분 뒤집기
	        int left = i, right = arr.length - 1;
	        while (left < right) {
	            swap(arr, left++, right--);
	        }

	        return true;
	    }

	    private static void swap(int[] arr, int i, int j) {
	        int tmp = arr[i];
	        arr[i] = arr[j];
	        arr[j] = tmp;
	    }

}
