import java.io.*;
import java.util.*;

public class NodeTree {
    public static void main(String[] args) throws Exception {
        int[] input = new int[]{3,1,2,4,5,9,8,7,10};

        Node root = new Node(6,null,null);

        for (int v : input) {
            Node temp = root;

            while (true) {
                if (v < temp.data) {
                    if (temp.left == null) {
                        temp.left = new Node(v, null, null);
                        break;
                    } else {
                        temp = temp.left;
                    }
                } else if (v == temp.data) {
                    break;
                } else {
                    if (temp.right == null) {
                        temp.right = new Node(v, null, null);
                        break;
                    } else {
                        temp = temp.right;
                    }
                }
            }
        }

        // 1) 콘솔 트리 시각화 (우측이 위로 나오게 출력)
        printTree(root);

        // 2) Graphviz dot 파일 생성 (tree.dot)
        writeDot(root, "tree.dot");
        System.out.println("\n(tree.dot 생성 완료)");
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    // =======================
    // 1) 콘솔 ASCII 출력
    // =======================
    static void printTree(Node root) {
        printTree(root, "", true);
    }

    // 오른쪽 서브트리를 먼저 출력해서 "오른쪽이 위"로 보이게 함
    static void printTree(Node node, String prefix, boolean isTail) {
        if (node == null) return;

        if (node.right != null) {
            printTree(node.right, prefix + (isTail ? "│   " : "    "), false);
        }

        System.out.println(prefix + (isTail ? "└── " : "┌── ") + node.data);

        if (node.left != null) {
            printTree(node.left, prefix + (isTail ? "    " : "│   "), true);
        }
    }

    // =======================
    // 2) Graphviz DOT 출력
    // =======================
    static void writeDot(Node root, String fileName) throws IOException {
        if (root == null) return;

        IdentityHashMap<Node, String> ids = new IdentityHashMap<>();
        Deque<Node> q = new ArrayDeque<>();
        q.add(root);
        int seq = 0;

        // 노드에 고유 id 부여
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (ids.containsKey(cur)) continue;
            ids.put(cur, "n" + (seq++));
            if (cur.left != null) q.add(cur.left);
            if (cur.right != null) q.add(cur.right);
        }

        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
            pw.println("digraph BST {");
            pw.println("  rankdir=TB;");
            pw.println("  node [shape=circle];");

            // 노드 라벨
            for (Map.Entry<Node, String> e : ids.entrySet()) {
                pw.printf("  %s [label=\"%d\"];%n", e.getValue(), e.getKey().data);
            }

            // 간선
            for (Map.Entry<Node, String> e : ids.entrySet()) {
                Node n = e.getKey();
                String from = e.getValue();
                if (n.left != null) {
                    pw.printf("  %s -> %s [label=\"L\"];%n", from, ids.get(n.left));
                }
                if (n.right != null) {
                    pw.printf("  %s -> %s [label=\"R\"];%n", from, ids.get(n.right));
                }
            }

            pw.println("}");
        }
    }
}
