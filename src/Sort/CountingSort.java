package Sort;

import java.util.Arrays;

public class CountingSort {

    // arr 원본을 "안정 정렬"로 카운팅 정렬해서 새 배열로 반환
    // 조건: arr의 모든 값은 0 이상, max 이하
    static int[] countingSortStable(int[] arr, int max) {
        int n = arr.length;
        int[] count = new int[max + 1];
        int[] result = new int[n];

        // 1) 개수 세기
        for (int v : arr) count[v]++;

        // 2) 누적합(각 값의 마지막 위치 + 1)
        for (int i = 1; i <= max; i++) count[i] += count[i - 1];

        // 3) 뒤에서부터 채워서 안정성 유지
        for (int i = n - 1; i >= 0; i--) {
            int v = arr[i];
            result[--count[v]] = v;
        }

        return result;
    }

    // "안정성 필요 없음" 버전: 개수만 세고 그대로 풀어내기
    // 조건: arr의 모든 값은 0 이상, max 이하
    static int[] countingSortSimple(int[] arr, int max) {
        int[] count = new int[max + 1];
        for (int v : arr) count[v]++;

        int[] result = new int[arr.length];
        int idx = 0;
        for (int v = 0; v <= max; v++) {
            for (int c = count[v]; c > 0; c--) {
                result[idx++] = v;
            }
        }
        return result;
    }

    // 예시
    public static void main(String[] args) {
        int[] input = {3, 1, 2, 2, 4, 5};
        int max = 5;

        System.out.println(Arrays.toString(countingSortStable(input, max)));
        System.out.println(Arrays.toString(countingSortSimple(input, max)));
    }
}
