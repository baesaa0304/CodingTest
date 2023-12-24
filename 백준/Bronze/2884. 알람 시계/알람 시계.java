import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b; // 시간 분
        a = sc.nextInt();
        b = sc.nextInt();
        if (b < 45) {
            a--;
            b = 60 - (45 - b);
            if (a < 0) {
                a = 23;
            }
            System.out.println(a + " " + b);
        } else {
            System.out.println(a + " " + (b - 45));
        }
    }
}
