import java.io.*;
import java.util.*;

public class Main {

    private static int[] cardDeck;
    private static int numOfCards;
    private static int targetNum;
    private static boolean[] visited;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        numOfCards = Integer.parseInt(st.nextToken());
        targetNum = Integer.parseInt(st.nextToken());
        cardDeck = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        visited = new boolean[cardDeck.length];

        getCombination(0, 0, 0);

        System.out.println(answer);
    }

    private static void getCombination(int start, int temp, int numOfPickedCards) {
        if (numOfPickedCards == 3) {
            if (temp <= targetNum && answer < temp) answer = temp;
            return;
        }

        for (int i = start; i < numOfCards; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            getCombination(i + 1, temp + cardDeck[i], numOfPickedCards + 1);
            visited[i] = false;
        }
    }

}
