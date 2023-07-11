import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int answer = 0;
    static BufferedReader br;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        countGroupWord(N);
        System.out.println(answer);
    }

    private static void countGroupWord(int N) throws IOException {
        for(int i = 0; i < N; i++) {
            String givenWord = br.readLine();
            if (isGroupWord(givenWord)) answer++;

        }
    }

    private static boolean isGroupWord(String word) {
        if (word.length() <= 2) return true;
        for (int i = 2; i < word.length(); i++) {
            char ithChar = word.charAt(i);
            if (ithChar == word.charAt(i-1)) continue; // check the character right before ith character (ex. aaa)

            for (int j = 0; j <= i - 2; j++) {
                char charBeforeIth = word.charAt(j);
                if (ithChar == charBeforeIth) return false;
            }
        }

        return true;
    }
}
