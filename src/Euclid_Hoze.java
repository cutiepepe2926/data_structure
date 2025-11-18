public class Euclid_Hoze {
    public static void main(String[] args) {
        System.out.println("30와 160의 최대공약수 : " + gcd(150,30));
    }

    public static int gcd(int x, int y) {
        if (y==0) {
            return x;
        }
        else {
            return gcd(y, x % y);
        }
    }
}
