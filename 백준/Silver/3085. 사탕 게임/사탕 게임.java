
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Character arr[][] = new Character[N][N];

        // 배열 입력 받기
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        System.out.println(findMaxCandy(N, arr)); // 최대 사탕 개수 출력
    }

    // **최대 사탕 개수 찾기**
    public static int findMaxCandy(int n, Character arr[][]) {
        int maxCandy = 0;

        // 현재 상태에서 최대 연속된 사탕 개수 계산
        maxCandy = Math.max(maxCandy, countMaxCandy(n, arr));

        //  모든 칸을 확인하면서 인접한 사탕을 교환
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 오른쪽 사탕과 교환 (j+1이 범위 내일 때)
                if (j + 1 < n) {
                    swap(arr, i, j, i, j + 1);  // 사탕 교환
                    maxCandy = Math.max(maxCandy, countMaxCandy(n, arr)); // 최대값 갱신
                    swap(arr, i, j, i, j + 1);  // 원래대로 복구
                }

                // **아래쪽 사탕과 교환 (i+1이 범위 내일 때)**
                if (i + 1 < n) {
                    swap(arr, i, j, i + 1, j);  // 사탕 교환
                    maxCandy = Math.max(maxCandy, countMaxCandy(n, arr)); // 최대값 갱신
                    swap(arr, i, j, i + 1, j);  // 원래대로 복구
                }
            }
        }

        return maxCandy;
    }

    // 최대 연속된 사탕 개수 찾기
    public static int countMaxCandy(int n, Character arr[][]) {
        int answer = 0;

        // **가로(행)에서 최대 연속 사탕 개수 찾기**
        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = 1; j < n; j++) {
                if (arr[i][j] == arr[i][j - 1]) count++; // 왼쪽과 비교
                else count = 1;
                answer = Math.max(answer, count);
            }
        }

        // **세로(열)에서 최대 연속 사탕 개수 찾기**
        for (int j = 0; j < n; j++) {
            int count = 1;
            for (int i = 1; i < n; i++) {
                if (arr[i][j] == arr[i - 1][j]) count++; // 위쪽과 비교
                else count = 1;
                answer = Math.max(answer, count);
            }
        }
        return answer;
    }

    // 사탕 위치 교환 함수
    public static void swap(Character arr[][], int x1, int y1, int x2, int y2) {
        Character temp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = temp;
    }
}
