import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        boolean arr[] = new boolean[31]; // true와 false의 결과값을 보여줌
        int k = 0; // 입력을 넣을 공간
        for (int i = 0; i < 28; i++) { // i가 28번을 수행할 때
            k = sc.nextInt(); // k에 정수 하나씩 입력 (k는 인덱스 번호)
            arr[k] = true; // 그 정수값 k을 true로 변환
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == false) {
                System.out.println(i); // 인덱스 번호를 출력
            }
        }
    }
}
