import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        StringBuilder answer = new StringBuilder();
        answer.append("<");
        while (!q.isEmpty()) {
            answer.append(pollKthElement(q, K));
            if (q.size() >= 1) answer.append(", ");
        }
        answer.append(">");

        System.out.println(answer.toString());
    }

    private static int pollKthElement(Queue<Integer> q, int K) {

        for(int i = 0; i < K - 1; i++) {
            q.add(q.poll());
        }

        return q.poll();
    }
}


