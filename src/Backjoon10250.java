import java.io.*;
import java.util.*;

public class Backjoon10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int XX = (N % H ==0)? (N / H) : (N / H + 1);
            int YY = (N % H ==0)? H : (N % H);
            sb.append(YY);
            if (String.valueOf(XX).length() < 2) {
                sb.append("0"+XX);
            }
            else {
                sb.append(XX);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}