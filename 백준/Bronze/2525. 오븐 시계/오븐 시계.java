import java.util.*;

public class Main {
    public static void main(String[] args) {
        int a, b, c, d;
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        d = b + c;
        
        if (d >= 60) {
            int hour, min;
            if (d % 60 == 0) {
                hour = a + (d / 60);
                min = 0;
            } else {
                hour = a + (d / 60);
                min = d % 60;
            }
            
            if (hour >= 24) {
                hour %= 24;  // 디지털 시계는 23시 59분에서 1분이 지나면 0시 0분이 된다.
            }

            System.out.println(hour + " " + min);
        } else {
            System.out.println(a + " " + d);
        }
    }
}
