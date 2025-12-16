package StringSearch;

public class BrutalForce {
    // 텍스트에서 패턴이 처음 등장하는 인덱스를 반환, 없으면 -1
    static int bruteForceSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        if (m == 0) return 0;

        for (int i = 0; i <= n - m; i++) { // 패턴이 들어갈 수 있는 시작 위치
            int j = 0;
            while (j < m && text.charAt(i + j) == pattern.charAt(j)) {
                j++;
            }
            if (j == m) return i; // 패턴 끝까지 다 맞음
        }
        return -1;
    }

    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";

        int idx = bruteForceSearch(text, pattern);
        System.out.println(idx); // 10
    }
}