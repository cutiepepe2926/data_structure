import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindMedicineNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the number of medicine you want to find : ");
        int n = Integer.parseInt(br.readLine());
        System.out.println(countDivisors(n));
    }

    static int countDivisors(long n) {
        int cnt = 0;

        for (int i = 1; i <= n/i; i++) {
            if (n%i == 0) {
                if (i == n / i) cnt +=1;
                else cnt +=2;
            }
        }
        return cnt;
    }
}
