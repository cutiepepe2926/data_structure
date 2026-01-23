package Graph;

import java.io.*;
import java.util.*;

public class GraphBFS_4_Direction {


    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = new int[]{-1,1,0,0};
    static int[] dy = new int[]{0,0,-1,1};
    static void bfs(int x, int y) {
        visited[x][y] = true;
        map[x][y] = 0;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x,y});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0]; int cy = cur[1];
            for (int dir = 0; dir < 4; dir++) {
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (map[nx][ny] == 0 || visited[nx][ny]) continue;
                visited[nx][ny] = true;
                map[nx][ny] = map[cx][cy] + 1;
                q.add(new int[]{nx,ny});
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 세로
        m = Integer.parseInt(st.nextToken()); // 가로

        // 초기화
        map = new int[n][m];
        visited = new boolean[n][m];

        int sn = 0; // 목표지점 세로
        int sm = 0; // 목표지점 가로

        // 입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 2) {
                    sn = i; sm = j;
                }
                map[i][j] = temp;
            }
        }

        // 목표지점에서부터 너비우선탐색 시작
        bfs(sn,sm);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    // -1 처리
                    sb.append("-1").append(" ");
                }
                else {
                    sb.append(map[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);

    }
}