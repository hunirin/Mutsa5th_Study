package boj;

import com.sun.tools.javac.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2798 {
    public int solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // 카드 갯수, 목표 숫자
        StringTokenizer infoToken = new StringTokenizer(reader.readLine());
        int cardCount = Integer.parseInt(infoToken.nextToken());
        int target = Integer.parseInt(infoToken.nextToken());

        StringTokenizer cardTokens = new StringTokenizer(reader.readLine());
        int[] cards = new int[cardCount];
        for (int i = 0; i < cardCount; i++) {
            cards[i] = Integer.parseInt(cardTokens.nextToken());
        }

        int max = 0;
        // 3장의 카드를 뽑는다.
        // for 첫번째 카드 -> n 장의 카드가 있다면 첫번째는 n - 2 까지
        for (int i = 0; i < cardCount - 2; i++) {
            // for 두번째 카드 -> 두번째는 n - 1 까지
            for (int j = 0; j < cardCount - 1; j++) {
                // for 세번째 카드 -> 세번째는 n 까지
                for (int k = 0; k < cardCount; k++) {
//                    System.out.println("선택한 카드 출력");
//                    // todo
//                    System.out.printf("%d %d %d%n", cards[i], cards[j], cards[k]);
                    int sum =  cards[i] + cards[j] + cards[k];
                    // 이번 카드 3장의 합이 여태까지 구한 것 중 제일 크다.
                    if (sum <= target && sum > max) max = sum;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new _2798().solution());
    }
}
