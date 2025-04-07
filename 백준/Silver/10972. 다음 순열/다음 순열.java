import java.io.*;
import java.util.*;


public class Main {
	 public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	
	    int[] arr = new int[N];
	    StringTokenizer st = new StringTokenizer(br.readLine());
	
	    for (int i = 0; i < N; i++) {
	        arr[i] = Integer.parseInt(st.nextToken());
	    }
	
	    if (nextPermutation(arr)) {
	        StringBuilder sb = new StringBuilder();
	        for (int num : arr) {
	            sb.append(num).append(" ");
	        }
	        System.out.println(sb.toString().trim());
	    } else {
	        System.out.println("-1");
	    }
	}
	
	// 다음 순열을 구하는 메서드
	private static boolean nextPermutation(int[] arr) {
	    int i = arr.length - 1;
	
	    // 1. 뒤에서부터 오름차순이 깨지는 지점 i-1 찾기
	    while (i > 0 && arr[i - 1] >= arr[i]) {
	        i--;
	    }
	
	    if (i == 0) return false; // 마지막 순열
	
	    // 2. arr[i - 1]보다 큰 수 찾기 (뒤쪽에서)
	    int j = arr.length - 1;
	    while (arr[i - 1] >= arr[j]) {
	        j--;
	    }
	
	    // 3. swap
	    swap(arr, i - 1, j);
	
	    // 4. i부터 끝까지 오름차순 정렬
	    int start = i, end = arr.length - 1;
	    while (start < end) {
	        swap(arr, start++, end--);
	    }
	
	    return true;
	}
	
	private static void swap(int[] arr, int a, int b) {
	    int tmp = arr[a];
	    arr[a] = arr[b];
	    arr[b] = tmp;
	}

}
