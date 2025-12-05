import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr1 = {
                187, 42, 399, 5, 276, 91, 453, 128, 310, 67,
                220, 14, 488, 173, 59, 361, 240, 7, 415, 102,
                334, 26, 470, 155, 80, 298, 11, 392, 205, 49,
                441, 120, 263, 33, 478, 166, 73, 319, 95, 231,
                12, 389, 214, 60, 452, 141, 287, 19, 406, 110,
                345, 28, 497, 158, 84, 301, 9, 374, 201, 53,
                430, 124, 255, 37, 466, 171, 76, 322, 99, 236,
                16, 381, 209, 63, 447, 135, 290, 23, 411, 115,
                356, 31, 490, 162, 88, 307, 3, 368, 198, 57,
                425, 129, 272, 40, 459, 180, 70, 333, 104, 242
        };

        mergeSort(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    // 병합 정렬
    public static void mergeSort(int[] a) {
        int[] temp = new int[a.length]; // 임시 배열 생성
        mergeSortSlice(a, temp, 0, a.length-1); // 재귀 정렬
    }

    // a[left]~a[right]를 재귀적으로 병합 정렬
    public static void mergeSortSlice(int[] a, int[] temp, int left, int right) {

        // 원소가 1개 또는 0개라 정렬 끝
        if (left >= right) return;

        // 가운데 인덱스 구하기
        int mid = (left + right) >>> 1;

        mergeSortSlice(a, temp, left, mid); // 왼쪽 구간 슬라이스
        mergeSortSlice(a, temp, mid+1, right); // 오른쪽 구간 슬라이스

        int pl = left; // 왼쪽 정렬 구간 포인터
        int pr = mid + 1; // 오른쪽 정렬 구간 포인터
        int writeIndex = left; // temp에 쓸 위치

        while (pl <= mid && pr <= right) { // 양쪽 포인터가 둘 다 구간 안에 있을 동안
            temp[writeIndex++] = (a[pl] <= a[pr]) // 더 작은 값을 temp 배열에 넣고, 해당 값 증가
                    ? a[pl++]
                    : a[pr++];
        }

        while (pl <= mid) { // 좌측 배열에서 남은거 싹 다 넣어버리기
            temp[writeIndex++] = a[pl++];
        }

        while (pr <= right) { // 우측 배열에서 남은거 싹 다 넣어버리기
            temp[writeIndex++] = a[pr++];
        }

        // 이번 구간 정렬 결과를 원본 배열에 반영하기
        for (int i = left; i <= right; i++) {
            a[i] = temp[i];
        }
    }
}
