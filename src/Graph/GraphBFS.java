package Graph;

import java.io.*;
import java.util.*;

public class GraphBFS {

    static List<Integer>[] graph; // 그래프
    static boolean[] visited; // 방문 체크
    static int[] order; // 방문 순서
    static int cnt; // 카운트
    static ArrayDeque<Integer> queue = new ArrayDeque<>();

    // BFS
    static void bfs(int x) {
        //Arrays.fill(visited,false); // 방문 배열 초기화
        visited[x] = true; // 시작 정점 방문 처리
        queue.add(x); // 시작 정점 큐 맨 뒤에 추가

        // 방문 순서 저장
        order[x] = cnt++;


        while (!queue.isEmpty()) { // 큐가 빌 때까지 반복
            int vertex = queue.poll(); // 큐에서 맨 앞에 값 꺼내기

            for (int v : graph[vertex]) { // 꺼낸 값 = 정점 -> 정점을 기준으로 도달 가능한 값에 대해서 반복
                if (!visited[v]) { // 만약 미방문시
                    visited[v] = true; // 방문처리 후

                    order[v] = cnt++; // 방문 순서 저장

                    queue.add(v); // 해당 값을 큐에 추가
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정점
        int m = Integer.parseInt(st.nextToken()); // 간선
        int r = Integer.parseInt(st.nextToken()); // 시작점

        // static 변수 초기화
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        order = new int[n+1];
        cnt = 1;
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        // 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v); graph[v].add(u);
        }

        // 너비 우선 탐색 전 순서 노드 방문 순서 오름차순 정렬
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        // 너비 우선 탐색
        bfs(r);

        // 값 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) sb.append(order[i]).append("\n");
        System.out.print(sb);

    }
}