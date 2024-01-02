import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int X, Y, a , b; // 영수증 값, 영수증 물건 갯수, 물품 가격 , 물품 목록
        int sum = 0;
        X = sc.nextInt();
        Y = sc.nextInt();
        for(int i =0; i < Y; i++){
            a = sc.nextInt();
            b = sc.nextInt();
            sum += (a * b);      
        }
        if (X == sum) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}