import java.io.*;
import java.util.*;

public class Backjoon1991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[26];
        Arrays.fill(nodes, new Node(".", null, null));
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String parent = st.nextToken();
            String leftChild = st.nextToken();
            String rightChild = st.nextToken();

            nodes[parent.charAt(0) - 'A'] = new Node(parent,
                    (leftChild.equals(".")) ? null : nodes[leftChild.charAt(0) - 'A'],
                    (rightChild.equals(".")) ? null : nodes[rightChild.charAt(0) - 'A'] );
        }



    }

    static class Node {
        String data;
        Node left;
        Node right;

        Node(String data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
