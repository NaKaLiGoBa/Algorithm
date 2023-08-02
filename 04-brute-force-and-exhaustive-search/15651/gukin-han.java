import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder answer = new StringBuilder();
    private static int[] candidates;
    private static List<Integer> oneOfAnswer = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        populateCandidates(n);
        getCombination(n, r);
        System.out.println(answer.toString());
    }

    private static void populateCandidates(int n) {
        candidates = new int[n];
        for (int i = 0; i < candidates.length; i++) {
            candidates[i] = i + 1;
        }
    }

    private static void getCombination(int n, int r) {
        if (r == 0) {
            getAnswer();
            return;
        }

        for (int i = 0; i < n; i++) {
            oneOfAnswer.add(candidates[i]);
            getCombination(n, r - 1);
            oneOfAnswer.remove(oneOfAnswer.size() - 1);
        }
    }

    private static void getAnswer() {
        for (int i = 0; i < oneOfAnswer.size(); i++) {
            answer.append(oneOfAnswer.get(i));
            if (i < oneOfAnswer.size() - 1) answer.append(" ");
        }
        answer.append("\n");
    }
}
