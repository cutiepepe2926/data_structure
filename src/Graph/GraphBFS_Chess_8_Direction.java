package Graph;

import java.io.*;
import java.util.*;

public class GraphBFS_Chess_8_Direction {

    static StringBuilder sb = new StringBuilder();
    static boolean[][] map;
    static int[][] howManyMoved;
    static int I;
    static int targetX;
    static int targetY;
    static int[] dx = new int[]{ -2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = new int[]{ 1, 2, 2, 1, -1, -2, -2, -1};
    static int cnt;
    static ArrayList<Integer> answer = new ArrayList<>();
    static void bfs(int x, int y) {
        map[x][y] = true;

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x,y});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0], curY = cur[1];

            if (curX == targetX && curY == targetY) {
                answer.add(howManyMoved[curX][curY]);
                return;
            }

            for (int dir = 0; dir < 8; dir++) {
                int nx = curX + dx[dir];
                int ny = curY + dy[dir];

                if (nx < 0 || nx >= I || ny < 0 || ny >= I) continue;
                if (map[nx][ny]) continue;
                map[nx][ny] = true;

                howManyMoved[nx][ny] = howManyMoved[curX][curY] + 1;
                q.add(new int[]{nx,ny});

            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            I = Integer.parseInt(br.readLine());
            map = new boolean[I][I];
            howManyMoved = new int[I][I];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            targetX = Integer.parseInt(st.nextToken());
            targetY = Integer.parseInt(st.nextToken());

            bfs(a,b);
        }
        for (int v : answer) sb.append(v).append("\n");
        System.out.print(sb);
    }
}