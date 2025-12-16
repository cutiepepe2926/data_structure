package Sort;

import java.io.*;

public class MergeSort2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];


        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        br.close();

        mergeSort(arr);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < arr.length; i++) {
            bw.write(arr[i]+"\n");
        }

        bw.flush();
        bw.close();
    }

    static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSortSlice(arr, temp, 0, arr.length-1);
    }

    static void mergeSortSlice(int[] arr, int[] temp, int left, int right) {
        if (left>=right) return;

        int mid = left+right >>> 1;

        mergeSortSlice(arr, temp, left, mid);
        mergeSortSlice(arr, temp, mid+1, right);

        int pl = left;
        int pr = mid + 1;
        int writeIndex = left;

        while (pl <= mid && pr <= right) {
            temp[writeIndex++] = (arr[pl] <= arr[pr])
                    ? arr[pl++]
                    : arr[pr++];
        }

        while (pl <= mid) {
            temp[writeIndex++] = arr[pl++];
        }

        while (pr <= right) {
            temp[writeIndex++] = arr[pr++];
        }

        for (int i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
    }
}