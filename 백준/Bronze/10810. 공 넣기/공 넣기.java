import java.util.Scanner;
public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 바구니의 갯수
        int M = sc.nextInt(); // 바구니에 공을 담는 횟수
        int bucket[] = new int[N];
        for (int i =0; i< M; i++) { //i는 공을 담는 횟수를 말함.
            int I = sc.nextInt(); // 공의 위치 첫번째 숫자
            int J = sc.nextInt(); // 공의 위치 마지막 숫자
            int K = sc.nextInt(); // 넣을 공의 갯수
            for(int j = I -1; j < J; j++) { // 
                bucket[j] = K;
                //System.out.println(bucket[j]); 이러면 바구니에 공을 담은 상태로 출력하여 출력 초과가 나옴                
            }            
        }
        for(int k =0; k < bucket.length; k++){
                System.out.println(bucket[k]);
            }
    }
}