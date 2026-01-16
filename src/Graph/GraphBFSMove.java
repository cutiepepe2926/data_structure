package Graph;

import java.io.*;
import java.util.*;

public class GraphBFSMove {
    // 상하좌우 전파 -> 단지찾기 ㅇㅇ

    static boolean[][] farm;
    static boolean[][] visited;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static int cnt;
    static int m;
    static int n;
    static StringBuilder sb = new StringBuilder();

    static void bfs(int s, int g) {
        visited[s][g] = true;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{s,g});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int sx = cur[0], sy = cur[1];
            for (int dir = 0; dir < 4; dir++) {
                int nx = sx + dx[dir];
                int my = sy + dy[dir];

                if (nx < 0 || nx >= n || my < 0 || my >= m) continue;
                if (!farm[nx][my] || visited[nx][my]) continue;
                visited[nx][my] = true;
                q.add(new int[]{nx,my});
            }
        }
        cnt++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken()); // 가로
            n = Integer.parseInt(st.nextToken()); // 세로
            int k = Integer.parseInt(st.nextToken()); // 배추 수

            farm = new boolean[n][m];
            visited = new boolean[n][m];
            cnt = 0;

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                farm[y][x] = true;

            }

            for (int sero = 0; sero < n; sero++) {
                for (int garo = 0; garo < m; garo++) {
                    if (farm[sero][garo] && !visited[sero][garo]) {
                        bfs(sero,garo);
                    }
                }
            }

            sb.append(cnt).append("\n");

        }
        System.out.print(sb);
    }
}
