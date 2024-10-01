import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];

      
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

      
        int min_number = Integer.MAX_VALUE; 
        int max_number = Integer.MIN_VALUE; 

        
        for (int i = 0; i < numbers.length; i++) {
            if (min_number > numbers[i]) {
                min_number = numbers[i];
            }
            if (max_number < numbers[i]) {
                max_number = numbers[i];
            }
        }
        
        
        System.out.println(min_number + " " + max_number);
    }
}
