import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int card[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        int findcard[] = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            findcard[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> cardCount = new HashMap<>();
        for (int value : card) {
            cardCount.put(value, cardCount.getOrDefault(value, 0) +1);
        }

        StringBuilder sb = new StringBuilder();
        for (int value : findcard) {
            sb.append(cardCount.getOrDefault(value, 0)).append(" ");
        }
        System.out.println(sb);
    }
}
