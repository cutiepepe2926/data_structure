package Graph;

import java.io.*;
import java.util.*;

public class Graph_Multi_BFS {

    static int m;
    static int n;
    static int[][] farm;
    static boolean[][] visited;
    static int[][] dist;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static ArrayList<int[]> start = new ArrayList<>();
    static void bfs(ArrayList<int[]> s) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        for (int[] curS : s) {
            visited[curS[0]][curS[1]] = true;
            q.add(curS);
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (farm[nx][ny] == -1) continue;
                if (visited[nx][ny]) continue;
                visited[nx][ny] = true;
                farm[nx][ny] = 1;

                dist[nx][ny] = dist[x][y] + 1;

                q.add(new int[]{nx,ny});
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        farm = new int[n][m];
        visited = new boolean[n][m];
        dist = new int[n][m];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int v = Integer.parseInt(st.nextToken());
                farm[i][j] = v;
                if (v == 1) {
                    start.add(new int[]{i,j});
                }
            }
        }

        bfs(start);

        int answer = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (farm[i][j] == 0) {
                    System.out.print(-1);
                    return;
                }
                answer = Math.max(answer, dist[i][j]);
            }
        }
        System.out.print(answer);
    }
}