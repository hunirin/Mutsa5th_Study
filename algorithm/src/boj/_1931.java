package boj;

import com.sun.tools.javac.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _1931 {
    public int solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int meetingCount = Integer.parseInt(reader.readLine());
        int[][] meetings = new int[meetingCount][2];
        for (int i = 0; i < meetingCount; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            meetings[i][0] = Integer.parseInt(tokenizer.nextToken());
            meetings[i][1] = Integer.parseInt(tokenizer.nextToken());
        }

        // Arrays.sort 배열을 정렬한다
        // 회의 정보를 종료시간 기준으로 정렬한다
        Arrays.sort(
                meetings,
//                Comparator.comparingInt(o -> o[1]));
                (o1, o2) -> {
                        // o1은 {시작시간, 종료시간}
                        // o2도 {시작시간, 종료시간}
                        // 종료 시간이 다르면 종료시간 기준 비교
                    if (o1[1] != o2[1]) return o1[1] - o2[1];
                    // 아니라면 시작 시간 기준 비교
                    return o1[0] - o2[0]; // 비교할 방법을 함수로 전달
                }
        );

        // 답안을 저장하기 위한 용도
        int answer = 0;
        // 마지막 종료시간을 저장하기 위한 용도
        int lastEnd = 0;
        for (int i = 0; i < meetingCount; i++) {
            // i번째 이번 미팅이 선택이 가능한지 판단하기 위해
            // i번째 미팅의 시작 시간과 현재 lastEnd를 비교한다
            if (meetings[i][0] >= lastEnd) {
                answer++;
                lastEnd = meetings[i][1];
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new _1931().solution());
    }
}

