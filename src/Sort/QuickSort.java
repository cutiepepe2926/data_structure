package Sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr1 = {5, 3, 8, 4, 9, 1, 6, 2, 7};
        quickSort(arr1, 0, arr1.length - 1);
        System.out.println(Arrays.toString(arr1));
    }

    // 분할(재귀)가 포함된 퀵 정렬
    public static void quickSort(int[] arr, int left, int right) {
        int pl = left; // 왼쪽 커서
        int pr = right; // 오른쪽 커서
        int pivot = arr[(pl+pr)/2]; // 피벗(가운데 요소)

        do {
            while( arr[pl] < pivot ) {
                pl++;
            }
            while( arr[pr] > pivot) {
                pr--;
            }
            if (pl <= pr) {
                swap(arr, pl++, pr--);
            }
        } while (pl <= pr);

        // 분할 한 범위에서 다시 재귀함수 호출
        if (left < pr) {
            quickSort(arr, left, pr);
        }
        if (pl < right) {
            quickSort(arr, pl, right);
        }

    }

    // 분할하지 않은 단순 partition 함수
//    public static void quickSort(int[] arr) {
//        int n = arr.length; // 배열의 길이
//        int pivot = arr[n/2]; // 배열 중앙의 임의의 pivot 값
//        int pl = 0; // 좌측 포인터
//        int pr = n - 1; // 우측 포인터
//
//        do {
//            // 좌측에서 우측으로 이동
//            while (arr[pl] < pivot) {
//                pl++;
//            }
//            // 우측에서 좌측으로 이동
//            while (arr[pr] > pivot) {
//                pr--;
//            }
//            // pivot을 기준으로 배열을 나눈다.
//            if (pl < pr) {
//                swap(arr, pl++, pr--); //범위에 안 맞는 것들 끼리 교환
//            }
//        } while (pl <= pr);
//
//    }

    public static void swap(int[] arr, int pl, int pr) {
        int tmp = arr[pl];
        arr[pl] = arr[pr];
        arr[pr] = tmp;
    }
}
