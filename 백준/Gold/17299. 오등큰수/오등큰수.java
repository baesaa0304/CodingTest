import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
       
        int N = Integer.parseInt(br.readLine()); // 수열의 길이
        
        int[] sequence = new int[N];  // 수열 저장 배열
        int[] result = new int[N];  // 오큰수를 저장할 배열
        
        // 숫자의 등장 빈도를 저장
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        // 수열 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
            // 등장 빈도 계산
            frequencyMap.put(sequence[i], frequencyMap.getOrDefault(sequence[i], 0) + 1);
        }

        // 오등큰수 계산
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && frequencyMap.get(sequence[stack.peek()]) < frequencyMap.get(sequence[i])) {
                int idx = stack.pop();
                result[idx] = sequence[i]; 
            }
            stack.push(i); 
        }

        
        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }

        
        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}