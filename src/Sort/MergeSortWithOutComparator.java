package Sort;

import java.time.LocalDate;
import java.util.*;

public class MergeSortWithOutComparator {
    public static void main(String[] args) {
        LocalDate[] arr = new LocalDate[3];

        arr[0] = LocalDate.of(2025, 2, 1); // 2번째 날짜
        arr[1] = LocalDate.of(2025, 1, 15); // 1번째 날짜
        arr[2] = LocalDate.of(2025, 3, 10); // 3번째 날짜

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }

    }
}


