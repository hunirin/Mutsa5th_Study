package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//aps
public class _1799 {
    // 하얀 비숍들이 들어갈 수 있는 칸
    private List<int[]> whitePoints;
    private int whiteMax;

    // 검은 비숍들이 들어갈 수 있는 칸
    private List<int[]> blackPoints;
    private int blackMax;

    public int solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());
        whitePoints = new ArrayList<>();
        whiteMax = 0;

        blackPoints = new ArrayList<>();
        blackMax = 0;

        for (int i = 0; i < size; i++) {
            StringTokenizer boardToken = new StringTokenizer(reader.readLine());
            for (int j = 0; j < size; j++) {
                // 검은색이냐 하얀색이냐
                if (Integer.parseInt(boardToken.nextToken()) == 1) {
                    if ((i + j) % 2 == 0) whitePoints.add(new int[]{i, j});
                    else blackPoints.add(new int[]{i, j});
                }
            }
        }

        dfsWhite(0, new boolean[whitePoints.size()]);
        dfsBlack(0, new boolean[blackPoints.size()]);

        return whiteMax + blackMax;
    }

    // 하얀색 비숍을 DFS 하는 함수
    private void dfsWhite(
            // 다음에 고려할 비숍이 놓일 칸
            // 의 whitePoints 인덱스
            int next,
            // 몇번째 비숍 칸들을 선택했는지
            boolean[] selected
    ) {
        // 종료조건 next == whitePoints.size()
        if (next == whitePoints.size()) {
            // 이번에 완성한 비숍들이 총 몇개가 쓰였는지
            int count = 0;
            for (boolean select: selected) {
                if (select) count += 1;
            }
            // 최댓값 갱신
            whiteMax = Math.max(whiteMax, count);
        }
        // 탐색하기
        else {
            selected[next] = true;
            // 다음 단계로 넘어가기 전에 가망성 조사를 해야함
            if(checkWhite(next, selected)) dfsWhite(next + 1, selected);
            selected[next] = false;
            dfsWhite(next + 1, selected);
        }
    }

    // 하얀색 비숍들이 서로 공격하지 못하는지 확인하는 함수
    private boolean checkWhite(int next, boolean[] selected) {
        // 마지막으로 선택한 비숍
        int[] point = whitePoints.get(next);
        for (int i = 0; i < next; i++) {
            if (
                    selected[i] &&
                    Math.abs(whitePoints.get(i)[0] - point[0])
                    == Math.abs(whitePoints.get(i)[1] - point[1])
            ) return false;
        }
        return true;
    }

    // 검은색색 비숍을 DFS 하는 함수
    private void dfsBlack(
            // 다음에 고려할 비숍이 놓일 칸
            // 의 blackPoints 인덱스
            int next,
            // 몇번째 비숍 칸들을 선택했는지
            boolean[] selected
    ) {
        // 종료조건 next == whitePoints.size()
        if (next == blackPoints.size()) {
            // 이번에 완성한 비숍들이 총 몇개가 쓰였는지
            int count = 0;
            for (boolean select: selected) {
                if (select) count += 1;
            }
            // 최댓값 갱신
            blackMax = Math.max(blackMax, count);
        }
        // 탐색하기
        else {
            selected[next] = true;
            // 다음 단계로 넘어가기 전에 가망성 조사를 해야함
            if(checkBlack(next, selected)) dfsBlack(next + 1, selected);
            selected[next] = false;
            dfsBlack(next + 1, selected);
        }
    }

    // 하얀색 비숍들이 서로 공격하지 못하는지 확인하는 함수
    private boolean checkBlack(int next, boolean[] selected) {
        // 마지막으로 선택한 비숍
        int[] point = blackPoints.get(next);
        for (int i = 0; i < next; i++) {
            if (
                    selected[i] &&
                            Math.abs(blackPoints.get(i)[0] - point[0])
                                    == Math.abs(blackPoints.get(i)[1] - point[1])
            ) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new _1799().solution());
    }
}
