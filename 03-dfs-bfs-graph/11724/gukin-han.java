import java.io.*;
import java.util.*;

public class Main{
    private static List<List<Integer>> graph = new ArrayList<>();
    private static int N;
    private static int M;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException{
        // process the inputs
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];

        for (int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<>());
        }

        // check whether nodes are linked
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int edgeFrom = Integer.parseInt(st.nextToken());
            int edgeTo = Integer.parseInt(st.nextToken());
            graph.get(edgeFrom).add(edgeTo);
            graph.get(edgeTo).add(edgeFrom);
        }

        System.out.println(getNumOfConnectedComponent());
    }

    private static int getNumOfConnectedComponent() {
        int count = 0;
        Queue<Integer> qForBfs = new LinkedList<>();
        for (int i = 1; i < graph.size(); i++) {
            if (visited[i]) continue;
            count++;
            qForBfs.add(i);
            while (!qForBfs.isEmpty()) {
                int from = qForBfs.poll();
                for (Integer to : graph.get(from)) {
                    if (!visited[to]) {
                        visited[to] = true;
                        qForBfs.add(to);
                    }
                }
            }
        }
        return count;
    }
}
