

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
        Arrays.sort(card);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int key = Integer.parseInt(st.nextToken());
            sb.append(BinarySearch(card, key)).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    private static int BinarySearch(int[] card, int key) {
        int start = 0;
        int end = card.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (key < card[mid]) {
                end = mid - 1;
            } else if (key > card[mid]) {
                start = mid + 1;
            } else {
                return 1;
            }
        }
        return 0;
    }
}
