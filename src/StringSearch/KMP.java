package StringSearch;

public class KMP {

    // pi[i] = pattern[0..i]에서 "가장 긴 접두사=접미사" 길이
    static int[] buildPi(String pattern) {
        int m = pattern.length();
        int[] pi = new int[m];

        int j = 0;
        for (int i = 1; i < m; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                pi[i] = ++j;
            }
        }
        return pi;
    }

    // text에서 pattern이 처음 등장하는 시작 인덱스 반환(없으면 -1)
    static int kmpSearchFirst(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        if (m == 0) return 0;
        if (n < m) return -1;

        int[] pi = buildPi(pattern);

        int j = 0; // pattern index
        for (int i = 0; i < n; i++) { // text index
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }
            if (text.charAt(i) == pattern.charAt(j)) {
                j++;
                if (j == m) {
                    return i - m + 1; // 매칭 시작 위치
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";

        System.out.println(kmpSearchFirst(text, pattern)); // 10
    }
}


