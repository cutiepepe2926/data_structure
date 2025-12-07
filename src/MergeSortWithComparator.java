import java.util.*;

public class MergeSortWithComparator {

    static class PhyscData {
        String name; // 이름
        int height; // 키
        double vision; // 시력

        // 생성자
        PhyscData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        // 신체검사 데이터를 문자열로 반환
        public String toString() {
            return name + " " + height + " " + vision;
        }

        // 키의 오름차순용 comparator
        static final Comparator<PhyscData> HEIGHT_ORDER = new HeightOrderComparator();

        // comparator 구현
        private static class HeightOrderComparator implements Comparator<PhyscData> {
            public int compare(PhyscData o1, PhyscData o2) {
                return Integer.compare(o1.height, o2.height);
//                return (o1.height > o2.height) ? 1 :
//                        (o1.height < o2.height) ? -1 : 0;
            }
        }
    }

    public static void main(String[] args) {
        PhyscData[] physcData = {
                new PhyscData("강민하", 162, 0.3),
                new PhyscData("김찬우", 173, 0.7),
                new PhyscData("박준서", 175, 2.0),
                new PhyscData("유서범", 171, 1.5),
                new PhyscData("이수연", 168, 0.4),
                new PhyscData("장경오", 174, 1.2),
                new PhyscData("황지민", 169, 0.8)
        };

        // 배열 x를 HEIGHT_ORDER를 사용하여 정렬
        Arrays.sort(physcData, PhyscData.HEIGHT_ORDER);

        System.out.println("신체검사 리스트");
        for (PhyscData physcData1 : physcData) {
            System.out.println(physcData1.toString());
        }

    }
}
