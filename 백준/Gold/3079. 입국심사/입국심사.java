import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(); // 심사대의 수
        int m = scanner.nextInt(); // 사람의 수
        
        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            times[i] = scanner.nextInt();
        }
        
        // 이진 탐색을 위한 변수 설정
        long left = 1;
        long right = (long) 1e18; // 충분히 큰 값으로 설정
        long result = right;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            
            if (canProcessAll(mid, times, m)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        System.out.println(result);
    }
    
    // 주어진 시간 내에 모든 사람을 심사할 수 있는지 확인하는 함수
    private static boolean canProcessAll(long time, int[] times, int m) {
        long count = 0;
        
        for (int t : times) {
            count += time / t;
            if (count >= m) return true; // 모든 사람을 심사할 수 있으면 true
        }
        
        return count >= m;
    }
}
