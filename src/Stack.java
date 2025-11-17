import java.util.*;

public class Stack {
    public static void main(String[] args) {

        IntStack stack = new IntStack(5);



        // 값 넣기 (push)
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        // 현재 스택 내용 출력
        System.out.print("현재 스택: ");
        stack.dump(); // 10 20 30 40 50

        // peek 테스트 (제일 위 원소만 확인)
        System.out.println("peek = " + stack.peek()); // 50

        // pop 테스트 (모두 꺼내기)
        while (!stack.isEmpty()) {
            int v = stack.pop();
            System.out.println("pop = " + v);
        }

        System.out.println("스택이 비었나요? " + stack.isEmpty());


    }


}

class IntStack {
    private int[] stk; //스택용 배열
    private int capacity; //스택 용량
    private int ptr; //스택 포인터

    // 실행 시 예외 : 스택이 비어 있음
    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() {}
    }

    // 실행 시 예외 : 스택이 가득 참
    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() {}
    }

    // 위 두 개의 예외는 push, pop, peek 메서드 사용 시 이용된다.

    // Stack 생성자
    public IntStack(int maxlen) {
        ptr = 0;
        capacity = maxlen;
        try {
            stk = new int[capacity];
        } catch (OverflowIntStackException e) {
            capacity = 0;
        }
    }

    // 스택에 x를 푸시
    public int push(int x) throws OverflowIntStackException {
        if (ptr >= capacity) {
            throw new OverflowIntStackException();
        }
        return stk[ptr++] = x;
    }

    // 스택에서 데이터를 팝(꼭대기 데이터 가져오기)
    public int pop() throws EmptyIntStackException {
        if (ptr<=0) { // 스택이 비어있는 경우
            throw new EmptyIntStackException();
        }
        return stk[--ptr];
    }

    // 스택에서 데이터를 피크(꼭대기에 있는 데이터를 들여다보기만 함, 가져오는 것 X)
    public int peek() throws EmptyIntStackException {
        if (ptr<=0) {
            throw new EmptyIntStackException();
        }
        return stk[ptr-1];
    }

    // 스택 데이터를 전부 비우기 (어차피 포인터를 0으로하면 데이터를 다시 넣을 때, 자동으로 채워짐)
    public void clear() {
        ptr = 0;
    }

    // 스택에서 x를 찾아 인덱스(없으면 -1)를 반환
    public int indexOf(int x) {
        for (int i=ptr - 1; i >= 0; i--) { // 꼭대기 쪽부터 선형 검색
            if (stk[i] == x) {
                return i;
            }
        }
        return -1;
    }

    // 스택의 용량을 반환 (데이터 갯수는 아님)
    public int getCapacity() {
        return capacity;
    }

    // 스택에 쌓여 있는 데이터 개수를 반환, 포인터가 가르키고있는게 현재 데이터 갯수
    public int size() {
        return ptr;
    }

    // 스택이 비어 있는 지 확인
    public boolean isEmpty() {
        return ptr <= 0;
    }

    // 스택이 가득 찼는 지
    public boolean isFull() {
        return ptr >= capacity;
    }

    // 스택 안의 모든 데이터를 바닥 -> 꼭대기 순서로 출력
    public void dump() {
        if (ptr <= 0) {
            System.out.println("Stack is empty");
        }
        else {
            for (int i = 0; i < ptr; i++) {
                System.out.print(stk[i] + " ");
            }
            System.out.println();
        }
    }
}