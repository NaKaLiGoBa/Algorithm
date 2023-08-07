import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static List<List<Integer>> linkPair = new ArrayList<>();
    private static int answer = 0;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfComputers = Integer.parseInt(br.readLine());
        int numOfComputerLinkPair = Integer.parseInt(br.readLine());
        visited = new boolean[numOfComputers];

        for (int i = 0; i <numOfComputers; i++) {
            linkPair.add(new ArrayList<>());
        }

        for (int i = 0; i <numOfComputerLinkPair; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1 ;
            int to = Integer.parseInt(st.nextToken()) - 1;

            linkPair.get(from).add(to);
            linkPair.get(to).add(from);
        }

        dfs(0);
        System.out.println(answer - 1);
    }

    private static void dfs(int start) {
        if (visited[start]) return;
        visited[start] = true;
        answer++;
        for (int to : linkPair.get(start)) {
            dfs(to);
        }
    }
}
