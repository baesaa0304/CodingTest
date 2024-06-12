import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] Number = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            Number[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(Number);
        
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int findNumber = Integer.parseInt(st.nextToken());
            sb.append(BinarySearch(Number, findNumber)).append("\n"); // 이분 탐색 결과를 추가하고 줄바꿈
        }
        System.out.print(sb.toString());
    }

    private static int BinarySearch(int[] number, int findNumber) {
        int lo = 0;
        int hi = number.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (findNumber < number[mid]) {
                hi = mid - 1;
            } else if (findNumber > number[mid]) {
                lo = mid + 1;
            } else {
                return 1; // 찾는 값이 배열에 존재할 경우 1 반환
            }
        }
        return 0; // 찾는 값이 배열에 존재하지 않을 경우 0 반환
    }
}
