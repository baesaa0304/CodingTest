import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] bucket = new int[N];
        int M = sc.nextInt();
        for(int a = 0; a < bucket.length; a++){
            bucket[a] = a + 1;
        }
        for (int i = 0; i < M; i++) {
            int I = sc.nextInt();
            int J = sc.nextInt();
            int temp = bucket[I - 1];
            bucket[I - 1] = bucket[J - 1];
            bucket[J - 1] = temp;
        }
        for (int k = 0; k < bucket.length; k++) {
            System.out.println(bucket[k]);
        }
    }
}
