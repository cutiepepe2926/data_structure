package BackTracking;

import java.io.*;
import java.util.*;

public class N_M_4 {

    static int N;
    static int M;
    static int[] memo;
    static StringBuilder sb = new StringBuilder();
    static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(memo[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {

            if (depth > 0 && memo[depth-1] > i) continue;

            memo[depth] = i;

            dfs(depth + 1);

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        memo = new int[M];

        dfs(0);

        System.out.print(sb);

    }
}