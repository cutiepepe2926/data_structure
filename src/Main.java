import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        ArrayList<Integer> al = new ArrayList<>();

        long cut = Math.round( (double)n * 0.15);

        for (int i = 0; i < n; i++) {
            al.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(al);

        long answer = 0;

        for (int i = (int)cut; i < al.size() - (int)cut; i++) {
            answer += al.get(i);
        }

        System.out.println(Math.round((float) answer /(n - cut*2)));

    }
}