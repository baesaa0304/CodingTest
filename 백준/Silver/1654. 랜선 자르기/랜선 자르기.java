import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int K = Integer.parseInt(st.nextToken()); // 필요한 랜선 개수
        int N = Integer.parseInt(st.nextToken()); // 이미 가지고 있는 랜선 개수
        
        int[] arr = new int[K];
        long max = 0;
        long min = 1;
        for (int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }
       
        long mid = 0;
        while (max >= min) {
            int cnt = 0;
            mid = (min + max) / 2;
            
            for (int i=0; i<arr.length; i++) {
                cnt += arr[i] / mid;
            }
            
            if (cnt < N) max = mid-1;
            else min = mid + 1;
        }
        
        mid = (min + max) / 2;
        System.out.println(mid);
    }
}