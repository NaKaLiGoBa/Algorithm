import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static List<Integer> temp = new ArrayList<>();
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[n];
        getCombination(n, r, visited);
        System.out.println(answer.toString());
    }

    private static void getCombination(int n, int r, boolean[] visited) {
        if (r == 0) {
            for (Integer i : temp) {
                answer.append(i).append(" ");
            }
            answer.append("\n");
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            temp.add(i + 1);
            getCombination(n, r - 1, visited);
            visited[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}
