import java.io.*;
import java.util.*;

public class Backjoon11493 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            // 1) 그래프 입력
            gInit(n, m);
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                gAdd(x, y);
                gAdd(y, x);
            }

            // 2) C, D 입력 (줄이 길 수 있으니 토큰 부족하면 다음 줄 읽는 방식으로 처리)
            int[] C = new int[n + 1];
            int[] D = new int[n + 1];

            int idx = 1;
            while (idx <= n) {
                if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens() && idx <= n) C[idx++] = Integer.parseInt(st.nextToken());
            }

            idx = 1;
            st = null;
            while (idx <= n) {
                if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens() && idx <= n) D[idx++] = Integer.parseInt(st.nextToken());
            }

            // 3) supply / demand 뽑기
            int[] supply = new int[n];
            int[] demand = new int[n];
            int sc = 0, dc = 0;

            for (int i = 1; i <= n; i++) {
                if (C[i] == 0 && D[i] == 1) supply[sc++] = i;      // 흰 동전이 남는거
                else if (C[i] == 1 && D[i] == 0) demand[dc++] = i; // 흰 동전이 필요한거
            }

            if (sc == 0) {
                sb.append(0).append('\n');
                continue;
            }

            // 4) 네트워크 구성
            // 노드 번호:
            // S=0
            // supply: 1..sc
            // demand: 1+sc .. sc+dc
            // T=1+sc+dc
            int k = sc; // sc == dc
            int S = 0;
            int supplyBase = 1;
            int demandBase = 1 + k;
            int TT = 1 + 2 * k;
            int V = TT + 1;

            // 간선 수(대략): S->k + k->k + k->T
            // addEdge가 정/역 2개 추가하므로 *2 해줘야 함
            int forward = k * k + 2 * k;
            int maxEdge = 2 * forward + 5;

            mInit(V, maxEdge);

            for (int i = 0; i < k; i++) addEdge(S, supplyBase + i, 1, 0);
            for (int j = 0; j < k; j++) addEdge(demandBase + j, TT, 1, 0);

            // 5) supply마다 BFS -> demand까지 거리 = 비용으로 간선 추가
            int[] dist = new int[n + 1];
            int[] q = new int[n + 5];

            for (int i = 0; i < k; i++) {
                bfs(supply[i], n, dist, q);
                int uNode = supplyBase + i;

                for (int j = 0; j < k; j++) {
                    int vNode = demandBase + j;
                    int w = dist[demand[j]]; // 최단거리 = swap 최소 횟수
                    addEdge(uNode, vNode, 1, w);
                }
            }

            // 6) 최소비용유량 = 정답
            long ans = minCostFlow(S, TT, k, V);
            sb.append(ans).append('\n');
        }

        System.out.print(sb);
    }

    // 원본 그래프 인접리스트 (BFS용)
    static int[] gHead, gTo, gNext;
    static int gEdgeCnt;

    static void gInit(int n, int m) {
        gHead = new int[n + 1];
        Arrays.fill(gHead, -1);
        gTo = new int[2 * m];
        gNext = new int[2 * m];
        gEdgeCnt = 0;
    }

    static void gAdd(int u, int v) {
        gTo[gEdgeCnt] = v;
        gNext[gEdgeCnt] = gHead[u];
        gHead[u] = gEdgeCnt++;
    }

    // 네트워크
    static int[] head, to, next, cap, cost;
    static int edgeCnt;

    static void mInit(int V, int maxEdge) {
        head = new int[V];
        Arrays.fill(head, -1);

        to = new int[maxEdge];
        next = new int[maxEdge];
        cap = new int[maxEdge];
        cost = new int[maxEdge];
        edgeCnt = 0;
    }

    // u->v 용량 c, 비용 w (역간선 자동 추가)
    static void addEdge(int u, int v, int c, int w) {
        to[edgeCnt] = v;
        cap[edgeCnt] = c;
        cost[edgeCnt] = w;
        next[edgeCnt] = head[u];
        head[u] = edgeCnt++;

        to[edgeCnt] = u;
        cap[edgeCnt] = 0;
        cost[edgeCnt] = -w;
        next[edgeCnt] = head[v];
        head[v] = edgeCnt++;
    }

    static long minCostFlow(int S, int T, int needFlow, int V) {
        final long INF = Long.MAX_VALUE / 4;

        long[] potential = new long[V]; // 잠재치(재가중치용)
        long[] dist = new long[V];
        int[] prevV = new int[V];
        int[] prevE = new int[V];

        long totalCost = 0;
        int flow = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));


        while (flow < needFlow) {
            Arrays.fill(dist, INF);
            Arrays.fill(prevV, -1);
            Arrays.fill(prevE, -1);

            dist[S] = 0;
            pq.clear();
            pq.add(new long[]{0, S});

            // 다익스트라 (재가중치된 비용으로)
            while (!pq.isEmpty()) {
                long[] cur = pq.poll();
                long d = cur[0];
                int u = (int) cur[1];
                if (d != dist[u]) continue;

                for (int e = head[u]; e != -1; e = next[e]) {
                    if (cap[e] <= 0) continue;
                    int v = to[e];

                    // 재가중치: cost + potential[u] - potential[v]
                    long nd = d + cost[e] + potential[u] - potential[v];
                    if (nd < dist[v]) {
                        dist[v] = nd;
                        prevV[v] = u;
                        prevE[v] = e;
                        pq.add(new long[]{nd, v});
                    }
                }
            }

            // 더 못 흘리면 종료 
            if (prevV[T] == -1) break;

            // 잠재치 갱신
            for (int i = 0; i < V; i++) {
                if (dist[i] < INF) potential[i] += dist[i];
            }

            // 이번에 흘릴 수 있는 유량 체크
            int add = needFlow - flow;
            for (int v = T; v != S; v = prevV[v]) {
                add = Math.min(add, cap[prevE[v]]);
            }

            // 유량 흘리기
            for (int v = T; v != S; v = prevV[v]) {
                int e = prevE[v];
                cap[e] -= add;
            }

            flow += add;
            totalCost += (long) add * potential[T]; // 원래 비용 기준 최단경로 비용
        }

        return totalCost;
    }

    // 정점에서 모든 정점까지 최단거리찾기
    static void bfs(int start, int n, int[] dist, int[] q) {
        Arrays.fill(dist, -1);
        int qs = 0, qe = 0;
        q[qe++] = start;
        dist[start] = 0;

        while (qs < qe) {
            int u = q[qs++];
            for (int e = gHead[u]; e != -1; e = gNext[e]) {
                int v = gTo[e];
                if (dist[v] != -1) continue;
                dist[v] = dist[u] + 1;
                q[qe++] = v;
            }
        }
    }
}
