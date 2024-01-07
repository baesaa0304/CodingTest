import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[] = new int[N];
        int a = sc.nextInt();
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }
        for(int j : arr){
            if(j < a) {
                System.out.println(j);
            }
        }
    }
}
