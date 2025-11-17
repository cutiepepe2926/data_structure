
public class factorial {

    public static void main(String[] args) {
        System.out.println(factorial(8));
    }

    // 해당 factorial 코드는 이해는 쉽지만, 효율적이지는 않다.
    // 해당 코드는 직접 재귀 형태임
    public static int factorial(int n) {
        if (n>0) {
            return n * factorial(n-1);
        }
        else {
            return 1;
        }
    }

}
