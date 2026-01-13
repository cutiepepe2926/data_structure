import java.io.*;
import java.util.*;

public class GraphDFS {

    static List<Integer>[] graph; // 그래프
    static boolean[] visited; // 방문체크용 배열
    static int[] order; // 방문 순서 저장
    static int cnt; // 순서변수

    // 깊이 우선 탐색
    static void dfs(int x) {
        visited[x] = true;
        order[x] = cnt++;

        for (int each : graph[x]) {
            if (!visited[each]) {
                dfs(each);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정점
        int m = Integer.parseInt(st.nextToken()); // 간선
        int r = Integer.parseInt(st.nextToken()); // 시작점

        // 초기 셋팅
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        order = new int[n+1];
        cnt = 1;

        // 초기화
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        // 간선 별 입력
        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st2.nextToken());
            int v = Integer.parseInt(st2.nextToken());

            graph[u].add(v); graph[v].add(u);
        }

        // 내림차순 정렬
        for (int i = 1; i <= n; i++) Collections.sort(graph[i], Collections.reverseOrder());

        // dfs
        dfs(r);

        // 순서 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(order[i]).append("\n");
        }
        System.out.print(sb);
    }
}