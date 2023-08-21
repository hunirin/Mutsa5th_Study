package graph;

import java.util.LinkedList;
import java.util.Queue;

public class Maze {
    private int[] dx = new int[]{-1, 1, 0, 0};
    private int[] dy = new int[]{0, 0, -1, 1};

    // 최단 거리를 돌려준다
    public int solution(int[][] maze) {
        // BFS 로직을 활용하는데,
        // 다음에 접근할 수 있는 칸을 maze의 가로 세로 크기 이내의 인접한 칸을
        // 기준으로 판단

        // int[]를 담는 Queue, {x, y, 여태까지 이동거리}
        Queue<int[]> visitNext = new LinkedList<>();
        // 미로에서 이미 도달한 적 있는 칸임을 나타내기 위한 visited 이차원 배열
        boolean [][] visited = new boolean[6][6];
        visitNext.offer(new int[]{5, 0, 0}); // 시작점
        int answer = -1; // 도달하지못했을때: -1, 도달했을 때 0;
        // BFS 시작
        // Queue가 비어있지 않은 동안
        while (!visitNext.isEmpty()) {
            // 다음에 갈곳을 Queue에서 꺼냄
            int[] next = visitNext.poll();
            int nowX = next[0];
            int nowY = next[1];
            int steps = next[2];
            // 현재 칸이 3이라면,
            if (maze[nowX][nowY] == 3) {
                answer = steps;
                break;
            }
            visited[nowX][nowY] = true;

            // 4개의 방향을 확인함
            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                if (
                        // 1. 미로의 범위를 벗어나진 않는지
                        checkBounds(nextX, nextY) &&
                        // 2. 미로에서 진행 가능한 칸인지 (0 또는 3)
                        (maze[nextX][nextY] == 0 || maze[nextX][nextY] == 3) &&
                        // 3. 아직 방문한적 없는지
                        !visited[nextX][nextY]
                ) {
                    // 큐에 방문 대상으로 기록
                    visitNext.offer(new int[]{nextX, nextY, steps + 1});
                }
            }

            // 위 (하나하나 자세히하면)
//            int[] top = new int[]{nowX -1, nowY, steps + 1};
//            // 1. 미로의 범위를 벗어나진 않는지
//            if (
//                    checkBounds(top[0], top[1]) &&
//                    (maze[top[0]][top[1]] == 0 || maze[top[0]][top[1]] == 3) &&
//                    !visited[top[0]][top[1]]
//            ) {
//
//            }
            // top[0], top[1]이 -1 보다는 크고, 6보다는 작아야 함
            // 2. 미로에서 진행 가능한 칸인지 (0 또는 3)
            // 3. 아직 방문한적 없는지
        }
        return answer;
    }

    // 미로의 범위 내에 있는지 검사하는 메소드
    private boolean checkBounds(int x, int y) {
        return -1 < x && x <6 && -1 < y && y < 6;
    }

    public static void main(String[] args) {

        // 2가 시작점, 3이 목적지
        int answer = new Maze().solution(new int[][]{
                {0, 0, 0, 0, 0, 3},
                {1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 1, 0},
                {1, 0, 1, 0, 1, 0},
                {0, 0, 1, 0, 0, 0},
                {2, 1, 1, 0, 1, 1}
        });
        System.out.println(answer);
    }
}
