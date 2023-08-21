package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class PostfixCalculation {

    public void solution() throws IOException {
        // 입력 처리
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        // 편의를 위해 한 자릿수만 사용, 나눗셈은 나머지 버림
        Stack<Integer> digitStack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char token = input.charAt(i);

            // 1. 숫자라면, 스택에 push
            // Character.isDigit(token): token이 숫자가 표현된 글자인지 판단하는 메소드

            if(Character.isDigit(token)) {
                // token을 int로 변환 => token - '0'
                digitStack.push(token - '0');
//                digitStack.push(Character.digit(token, 10));
            }
            // 2. 숫자가 아니라면(연산자), 스택에서 두번 pop하고 계산
            else {
                int numRight = digitStack.pop();
                int numLeft = digitStack.pop();
//                if (token == '+') digitStack.push(numLeft + numRight);
//                if (token == '-') digitStack.push(numLeft - numRight);
//                if (token == '*') digitStack.push(numLeft * numRight);
//                if (token == '/') digitStack.push(numLeft / numRight);
                switch (token) {
                    case '+':
                        digitStack.push(numLeft + numRight);
                        break;
                    case '-':
                        digitStack.push(numLeft - numRight);
                        break;
                    case '*':
                        digitStack.push(numLeft * numRight);
                        break;
                    case '/':
                        digitStack.push(numLeft / numRight);
                        break;
                    default:
                        throw new IllegalArgumentException("invalid operator");
                }
            }
            // 3. digitStack에 남은 연산 결과 값을 출력, pop
            int answer = digitStack.pop();
            if(digitStack.empty())
                System.out.println(answer);
            else System.out.println("error");
        }
    }

    public static void main(String[] args) throws IOException {
        new PostfixCalculation().solution();
    }
}
