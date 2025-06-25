import java.io.*;
import java.util.*;

public class Main {
    static char[][] tree = new char[26][2];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 트리 입력 받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            tree[root - 'A'][0] = left;
            tree[root - 'A'][1] = right;
        }

        preorder('A');
        sb.append('\n');
        inorder('A');
        sb.append('\n');
        postorder('A');

        System.out.println(sb);
    }

    // 전위 순회
    static void preorder(char node) {
        if (node == '.') return;
        sb.append(node);
        preorder(tree[node - 'A'][0]);
        preorder(tree[node - 'A'][1]);
    }

    // 중위 순회
    static void inorder(char node) {
        if (node == '.') return;
        inorder(tree[node - 'A'][0]);
        sb.append(node);
        inorder(tree[node - 'A'][1]);
    }

    // 후위 순회
    static void postorder(char node) {
        if (node == '.') return;
        postorder(tree[node - 'A'][0]);
        postorder(tree[node - 'A'][1]);
        sb.append(node);
    }
}