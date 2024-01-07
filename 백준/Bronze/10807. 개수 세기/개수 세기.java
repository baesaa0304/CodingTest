import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int a [] = new int[N];
        for(int i =0; i < a.length; i++){
            a[i] = sc.nextInt();
        }

        int b = sc.nextInt(); // 같은 수
        int count = 0; // 갯수세기기
        for (int j : a) {
            if(j == b) {
                count++;
            }
        } 
        System.out.println(count);      
    }
}