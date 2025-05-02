import java.io.*;
import java.util.*;


public class Main {
    static StringBuilder sb = new StringBuilder();
    static HashSet<Integer> hash = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("all")) {
                for (int j = 1; j <= 20; j++) hash.add(j);
            } else if (command.equals("empty")) {
                hash.clear();
            } else {
                int number = Integer.parseInt(st.nextToken());
                solution(command, number);
            }
        }
        System.out.println(sb.toString());
    }

    public static void solution(String s, int n) {
        switch (s) {
            case "add":
                hash.add(n);
                break;
            case "remove":
                hash.remove(n);
                break;
            case "check":
                if (hash.contains(n)) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
                break;
            case "toggle":
                if (hash.contains(n))
                    hash.remove(n);
                else
                    hash.add(n);
                break;
        }
    }
}