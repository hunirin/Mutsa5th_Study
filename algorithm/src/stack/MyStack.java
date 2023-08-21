package stack;

public class MyStack {
    //스택에 실제 데이터가 저장되는 곳
    private final int[] arr = new int[16]; // [0 ~ 15] -> 15 = arr.length-1
    // 현재 스택의 최고점을 파악하기 위한 top
    private int top = -1;

    public MyStack(){}

    // push: 데이터를 스택의 제일 위에 넣는 메소드
    public void push(int data) {
        // 0. arr가 가득 찼는지를 판단한다.
        if (arr.length - 1 == top) {
            throw new RuntimeException("stack is full");
        }
        // 1. top을 하나 증가시킨다.
        top++;

        // 2. arr[top]에 data를 할당한다.
        arr[top] = data;

        //끝
    }

    // pop: 데이터를 스택의 제일 위에서 회수하는 메소드
    public int pop() { // 언제나 제일 위에 있는걸 반환하니까 매개변수 필요x
        // 0. arr가 비어있는지 판단한다. (top을 기준)
        if (top == -1) {
            throw new RuntimeException("stack is empty");
        }
        // 1. arr[top]의 값을 임시저장한다.
//        int temp = arr[top];

        // 2. top의 값을 하나 감소한다.
//        top--;

        // 3. return temporary value
//        return temp;
        return arr[top--];

        // done!
    }

    // peek: return the top of stack without removing
    // without removing => do not change top
    public int peek() {
        // 0. check if stack not empty
        if (top == -1) {
            throw new RuntimeException("Stack is empty");
        }
        // 1. return arr[top];
        return arr[top];
    }

    // empty: check if stack is empty
    public boolean isEmpty() {
        // stack is empty when top == -1
        return top == -1;
    }

    public static void main(String[] args) {
        // 스택에 3개의 데이터를 넣었다가 빼보자
        MyStack intStack = new MyStack();
        intStack.push(3);
        intStack.push(5);
        intStack.push(7);
        System.out.println(intStack.pop());
        System.out.println(intStack.pop());
        System.out.println(intStack.pop());
        System.out.println(intStack.isEmpty());
        System.out.println(intStack.peek());
    }
}
