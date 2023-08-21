package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// BackTracking
public class _3344 {
    private int[] queenPos; // 각 행에서 퀸이 위치한 열의 값을 저장하는 배열
    private int size;       // 체스판의 크기 -> N * N
    private int count;      // N-Queen 문제의 해의 개수

    public int solution() throws IOException {
        // 사용자로부터 체스판의 크기를 입력받음
        size = Integer.parseInt(
                new BufferedReader((
                        new InputStreamReader(System.in))).readLine());
        queenPos = new int[size];
        count = 0;
        // 퀸을 첫번째 행부터 배치 시작
        setQueenPos(0);

        return count;   // 문제 해의 개수 반환
    }

    // 해당 행에 퀸을 배치하는 메소드
    private void setQueenPos(int row) {
        // 모든 행에 퀸을 배치하였다면, count를 증가시킴
        if (row == size) {
            count++;
        } else {
            for (int i = 0; i < size; i++) {
                // 해당 행의 i열에 퀸을 배치
                queenPos[row] = i;
                // 현재 배치가 유효한지 검사하고, 유효하다면 다음행에 퀸을 배치
                if (checkQueen(row)) setQueenPos(row + 1);
            }
        }
    }

    // 현재 배치가 유효한지 검사하는 메소드
    private boolean checkQueen(int row) {
        for (int i = 0; i < row; i++) {
            // 같은 열에 퀸이 있는지 검사
            if (queenPos[i] == queenPos[row])
                return false;
            // 대각선에 퀸이 있는지 검사
            else if ((Math.abs(queenPos[i] - queenPos[row]) == row - i))
                return false;
        }
        // 위의 두 조건을 만족하지 않으면 유효
        return true;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new _3344().solution());
    }
}
