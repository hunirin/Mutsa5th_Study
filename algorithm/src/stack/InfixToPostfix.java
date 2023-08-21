package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// Infix -> 중위표기법
// Postfix -> 후위표기법
public class InfixToPostfix {
    // 연산자인지 검증하는 메소드
    private boolean isOperator(char token) {
        return token == '(' || token == '+' || token == '-' || token == '*' || token == '/';
    }

    // 스택 내부에서의 우선순위
    private int inStackPriority(char operator) {
        if(operator == '+' || operator == '-') return 1;
        else if (operator == '*' || operator == '/') return 2;
        else if (operator == '(') return 0; // 닫는 괄호가 나올때까지 pop이 되면 안되서 0
        else throw new IllegalArgumentException("not allowed operator");
    }
    // 스택 외부에서의 우선순위
    private int inComingPriority(char operator) {
        if(operator == '+' || operator == '-') return 1;
        else if (operator == '*' || operator == '/') return 2;
        else if (operator == '(') return 3;
        else throw new IllegalArgumentException("not allowed operator");
    }

    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        // 결과를 담아둘 StringBuilder
        StringBuilder answerBuilder = new StringBuilder();
        // 연산자 담는 스택 (operator)
        Stack<Character> operStack = new Stack<>();

        // 문자 단위로 순회
        for (int i = 0; i < input.length(); i++) {
            char token = input.charAt(i);
            // TODO 연산자(+, -, *, /, '(')일 때
            if (isOperator(token)) {
                // TODO 스택이 비어있다면 push (if)
                if (operStack.empty()) {
                    operStack.push(token);
                }
                // TODO 스택이 비지 않았다면, (else)
                else {
                    // TODO 스택의 제일 위의 연산자가 나보다 우선순위가 낮은 연산자가 올때까지 pop (while)
                    while (inStackPriority(operStack.peek()) >= inComingPriority(token)) {
                        answerBuilder.append(operStack.pop());
                        // TODO 순회 중 스택이 다 빌 경우 반복 중단 (if break)
                        if (operStack.empty()) break;
                    }
                    // TODO while 종료 후 push
                    operStack.push(token);
                }


            }
            // 닫는 괄호일때
            else if (token == ')') {
                // TODO 스택에서 여는 괄호가 나올때까지 pop
                char top = operStack.pop();
                while (top != '(') {
                    answerBuilder.append(top);
                    top = operStack.pop();
                }
            }
            // 숫자의 경우 바로 출력
            else answerBuilder.append(token);
        }
        // TODO 연산자 스택이 빌때까지 pop
        while (!operStack.empty()) {
            answerBuilder.append(operStack.pop());
        }
        System.out.println(answerBuilder);
    }

    //
    public static void main(String[] args) throws IOException{
        new InfixToPostfix().solution();
    }
}
