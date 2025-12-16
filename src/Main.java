import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String T = br.readLine();
        String P = br.readLine();
        br.close();
        StringBuilder sb = new StringBuilder();
        int index = -1;
        int num = 0;
        while (true) {
            if (index+1 >= T.length()) break;
            index = T.indexOf(P, index + P.length());
            if (index == -1) break;
            num++;
            sb.append(index+1).append("\n");
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(num).append("\n").append(sb);
        System.out.println(sb2);
    }
}