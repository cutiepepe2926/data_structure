import java.util.Arrays;

public class QuickSort2 {
    public static void main(String[] args) {
        int[] arr1 = {5, 3, 8, 4, 9, 1, 6, 2, 7};
        quickSort2(arr1, 0, arr1.length - 1);
        System.out.println(Arrays.toString(arr1));
    }

    // 분할(재귀)가 포함된 퀵 정렬
    public static void quickSort2(int[] arr, int left, int right) {
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
            quickSort2(arr, left, pr);
        }
        if (pl < right) {
            quickSort2(arr, pl, right);
        }

    }

    public static void swap(int[] arr, int pl, int pr) {
        int tmp = arr[pl];
        arr[pl] = arr[pr];
        arr[pr] = tmp;
    }
}
