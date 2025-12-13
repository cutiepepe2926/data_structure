import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 0;
        StringBuilder answer = new StringBuilder();
        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n == -1) break;

            StringBuilder sb = new StringBuilder();
            sb.append(n).append(" ");
            ArrayList<Integer> al = new ArrayList<>();
            int sum = 0;

            for (int i = 1; i < n; i++) {
                if (n % i == 0) {
                    al.add(i);
                    sum += i;
                }
            }

            if (n != sum) {
                sb.append("is NOT perfect.");
            }
            else {
                sb.append("= ");
                for (int i = 0; i < al.size(); i++) {
                    if (i == al.size()-1) {
                        sb.append(al.get(i));
                    }
                    else {
                        sb.append(al.get(i)).append(" + ");
                    }
                }
            }

            answer.append(sb).append("\n");

        }

        System.out.println(answer);
    }
}