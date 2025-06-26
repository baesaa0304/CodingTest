import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int left, right;

        Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    static Map<Integer, Node> tree = new HashMap<>();
    static int[] parent;
    static int[] minX;
    static int[] maxX;
    static int x = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        parent = new int[n + 1];
        minX = new int[n + 1];
        maxX = new int[n + 1];
        Arrays.fill(minX, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            tree.put(cur, new Node(left, right));

            if (left != -1) parent[left] = cur;
            if (right != -1) parent[right] = cur;
        }

        int root = findRoot(n);
        inorder(root, 1);

        int level = 1;
        int maxWidth = 1;

        for (int i = 1; i <= n; i++) {
            if (minX[i] == Integer.MAX_VALUE) continue;
            int width = maxX[i] - minX[i] + 1;
            if (width > maxWidth) {
                maxWidth = width;
                level = i;
            }
        }

        System.out.println(level + " " + maxWidth);
    }

    static int findRoot(int n) {
        for (int i = 1; i <= n; i++) {
            if (parent[i] == 0) return i;
        }
        return -1; // not found
    }

    static void inorder(int node, int depth) {
        if (node == -1) return;

        Node cur = tree.get(node);

        inorder(cur.left, depth + 1);
        minX[depth] = Math.min(minX[depth], x);
        maxX[depth] = Math.max(maxX[depth], x++);
        inorder(cur.right, depth + 1);
    }
}