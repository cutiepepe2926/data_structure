import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        User[] userList = new User[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            userList[i] = new User(Integer.parseInt(st.nextToken()), st.nextToken(), i);
        }

        Arrays.sort(userList, (a,b) -> {
            int aAge = a.age;
            int bAge = b.age;

            if (aAge == bAge) {
                return a.howFast - b.howFast;
            }
            return aAge - bAge;
        });

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (User u : userList) {
            bw.write(u.age + " "+u.name+"\n");
        }

        bw.flush();
        bw.close();

    }

    public static class User {
        int age;
        String name;
        int howFast;

        User(int age, String name, int howFast) {
            this.age = age;
            this.name = name;
            this.howFast = howFast;
        }
    }
}