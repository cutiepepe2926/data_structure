package Graph;

import java.io.*;
import java.util.*;

public class Graph_Mutil_BFS_3D {

    static int m; // 가로(x축)
    static int n; // 세로(y축)
    static int h; // 높이(z축)
    static int[] dx = new int[]{1,-1,0,0,0,0}; // 좌우
    static int[] dy = new int[]{0,0,1,-1,0,0}; // 앞뒤
    static int[] dz = new int[]{0,0,0,0,1,-1}; // 위아래
    static ArrayDeque<int[]> q = new ArrayDeque<>(); // bfs 미리 빼논 큐
    static int[][][] farm; // 농장
    static void bfs() {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curZ = cur[0];
            int curY = cur[1];
            int curX = cur[2];

            for (int dir = 0; dir < 6; dir++) {
                int nz = curZ + dz[dir];
                int ny = curY + dy[dir];
                int nx = curX + dx[dir];

                if (nz >= 0 && nz < h
                        && ny >= 0 && ny < n
                        && nx >= 0 && nx < m
                        && farm[nz][ny][nx] == 0) {
                    farm[nz][ny][nx] = farm[curZ][curY][curX] + 1;
                    q.add(new int[]{nz,ny,nx});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); // 가로
        n = Integer.parseInt(st.nextToken()); // 세로
        h = Integer.parseInt(st.nextToken()); // 높이
        farm = new int[h][n][m];

        int cnt = 0;

        for (int z = 0; z < h; z++) {
            for (int y = 0; y < n; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < m; x++) {
                    int v = Integer.parseInt(st.nextToken());
                    if (v!=0) {
                        farm[z][y][x] = v;
                        if (v == 1) q.add(new int[]{z,y,x});
                    }
                    else {
                        cnt++;
                    }
                }
            }
        }

        if (cnt == 0) {
            System.out.print(0);
            return;
        }
        else {
            bfs();
        }

        int answer = 0;
        for (int z = 0; z < h; z++) {
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    if (farm[z][y][x] == 0) {
                        System.out.print(-1);
                        return;
                    }
                    else answer = Math.max(answer,farm[z][y][x]);
                }
            }
        }
        System.out.print(answer - 1);
    }
}