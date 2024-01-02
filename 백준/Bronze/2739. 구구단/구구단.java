import java.util.*;
public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        sc.close();
        for(int j = 1; j < 10; j++){
            System.out.println(a + " * " + j + " = " + (a * j));
        } 
    }
}