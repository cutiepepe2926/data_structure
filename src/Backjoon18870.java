import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Backjoon18870 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] unzip =  new int[n];
        TreeSet<Integer> ts = new TreeSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            ts.add(num);
            unzip[i] = num;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        int coordinate = 0;
        for (int v : ts) {
            map.put(v, coordinate++);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < n; i++) {
            bw.write(map.get(unzip[i]) + " ");
        }

        bw.flush();
        bw.close();
    }
}