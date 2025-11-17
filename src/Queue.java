

public class Queue {
    public static void main(String[] args) {
        // 길이 5짜리 큐 생성
        IntQueue q = new IntQueue(5);

        // 1) enque 테스트
        System.out.println("=== enque 테스트 ===");
        q.enque(10);
        q.enque(20);
        q.enque(30);
        System.out.println("현재 size : " + q.size());     // 3
        System.out.println("peek 값  : " + q.peek());     // 10

        // 2) dump 테스트 (front → rear 방향으로 출력)
        System.out.println("\n=== dump 테스트 ===");
        q.dump();  // 10 20 30

        // 3) deque 테스트
        System.out.println("\n=== deque 테스트 ===");
        int d1 = q.deque();
        int d2 = q.deque();
        System.out.println("deque 1 : " + d1);     // 10
        System.out.println("deque 2 : " + d2);     // 20
        System.out.println("현재 size : " + q.size()); // 1
        System.out.println("현재 peek : " + q.peek()); // 30

        // 4) 원형 큐 동작 확인 (rear, front가 한 바퀴 도는지)
        System.out.println("\n=== 원형 큐 동작 확인 ===");
        q.enque(40);
        q.enque(50);
        q.enque(60); // 이제 큐가 가득 참 (총 4개: 30,40,50,60)

        System.out.println("isFull? " + q.isFull());
        q.dump();

        // 5) indexOf 테스트
        System.out.println("\n=== indexOf 테스트 ===");
        System.out.println("30의 인덱스 : " + q.indexOf(30));
        System.out.println("50의 인덱스 : " + q.indexOf(50));
        System.out.println("99의 인덱스 : " + q.indexOf(99)); // -1

        // 6) clear 테스트
        System.out.println("\n=== clear 테스트 ===");
        q.clear();
        System.out.println("clear 후 isEmpty? " + q.isEmpty());
        q.dump(); // "큐가 비어 있습니다." 출력
    }
}

class IntQueue {
    private int[] que; // 큐용 배열
    private int capacity; // 큐의 용량
    private int front; // 맨 앞의 요소 커서
    private int rear; // 맨 뒤의 요소 커서
    private int num; // 현재 데이터 개수

    public class EmptyIntQueueException extends RuntimeException {
        public EmptyIntQueueException() {}
    }

    public class OverflowIntQueueException extends RuntimeException {
        public OverflowIntQueueException() {}
    }

    // 생성자
    public IntQueue(int maxlen) {
        num = front = rear = 0;
        capacity = maxlen;

        try {
            que = new int[capacity]; // 큐 본체용 배열을 생성
        } catch (OutOfMemoryError e) {
            capacity = 0;
        }
    }

    // 큐에 데이터를 인큐 (삽입)
    public int enque(int x) throws OverflowIntQueueException {
        if (num >= capacity) {
            throw new OverflowIntQueueException(); // 큐가 가득 차는 경우, 예외 던지기
        }

        que[rear++] = x; // 맨 뒤 요소 커서인 rear를 index로 que[rear] 값에 x값을 저장 후 rear 값 증가
        num++; // 마찬가지로 현재 데이터 개수도 추가

        if(rear == capacity) { // 만약, 맨 뒤 요소 커서인 rear가 큐의 용량인 capacity와 같아진다면,
            // rear가 원을 한 바퀴 돈 걸로 판단해 rear 값을 0으로 설정(한 바퀴 돌리는 형태)
            rear = 0;
        }

        return x; // enque 한 값을 그대로 되돌려 줌 - 꼭 이렇게 할 필요는 없음
    }

    // 큐에 데이터를 디큐 (추출)
    public int deque() throws EmptyIntQueueException {
        if (num <= 0) {
            throw new EmptyIntQueueException(); // 큐가 비어 있는 경우, 예외 던지기
        }

        int x = que[front++]; // 맨 앞 요소 커서인 front를 index로 que[front] 값을 x에 저장 후 front 값 증가
        num--; // 현재 데이터 개수 감소

        if (front == capacity) { // 만약, 맨 앞 요소 커서인 front가 큐의 용량인 capacity와 같아진다면,
            // front가 원을 한 바퀴 돈 걸로 판단해 front 값을 0으로 설정(한 바퀴 돌리는 형태)
            front = 0;
        }

        return x; // deque로 추출한 값을 그대로 전달해줌

    }

    // 큐에서 데이터를 피크(front 데이터를 들여다보기)
    public int peek() throws EmptyIntQueueException {
        if (num <= 0) {
            throw new EmptyIntQueueException();
        }
        return que[front];
    }

    // 큐를 비움
    public void clear() {
        num = front = rear = 0;
    }

    // 큐에서 x를 검색하여 인덱스 반환(실패 시 -1 반환)
    public int indexOf(int x) {
        for (int i = 0; i < num; i++) { //현재 데이터 개수만큼 반복하되
            int idx = (i+front) % capacity; //capacity 안에서만 동작함.
            if (que[idx] == x) {
                return idx; // 일치 시 인덱스 값 반환
            }
        }
        return -1; // 검색 실패
    }

    // 큐의 용량을 반환
    public int getCapacity() {
        return capacity;
    }

    // 큐에 쌓여 있는 데이터의 개수를 반환
    public int size() {
        return num;
    }

    // 큐가 비어 있는가?
    public boolean isEmpty() {
        return num <= 0;
    }

    // 큐가 가득 차 있는가?
    public boolean isFull() {
        return num >= capacity;
    }

    // 큐 안의 모든 데이터를 프런트 -> 리어 순서로 출력
    public void dump() {
        if (num<= 0) {
            System.out.println("큐가 비어 있습니다.");
        }
        else {
            for (int i = 0; i < num; i++) {
                System.out.println(que[(i+front)%capacity] + " ");
            }
        }
    }


}