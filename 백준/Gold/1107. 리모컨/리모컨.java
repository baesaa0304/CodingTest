
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 이동하는 채널 
        int M = Integer.parseInt(br.readLine()); // 고장난 버튼 개수
        boolean[] broken = new boolean[10]; // 0~9까지 버튼 상태

        if (M > 0) { // 고장난 버튼이 있을 때만 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        System.out.println(solution(N, broken));
    }

    public static int solution(int n, boolean[] broken) {
        int answer = Math.abs(n - 100); // 100에서 + / - 버튼만 사용하는 경우

        // 0부터 999999까지 모든 숫자를 확인
        for (int i = 0; i <= 999999; i++) {
            String num = String.valueOf(i);
            boolean isBreak = false;

            // 현재 숫자가 고장난 버튼을 포함하는지 확인 
            for (int j = 0; j < num.length(); j++) {
                if (broken[num.charAt(j) - '0']) {
                    isBreak = true;
                    break;
                }
            }

            if (!isBreak) {
                // 버튼을 눌러서 이동한 후, + / - 버튼 사용
                int min = Math.abs(n - i) + num.length();
                answer = Math.min(min, answer);
            }
        }
        return answer;
    }
}