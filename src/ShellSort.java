import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr1 = {5, 1, 4, 2, 8, 0, 3};
        shellSort(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    public static void shellSort(int[] arr) {

    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
