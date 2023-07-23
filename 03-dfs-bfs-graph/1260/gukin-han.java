import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N+1][N+1];
        boolean[] visited = new boolean[N + 1];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph[from][to] = 1;
            graph[to][from] = 1;
        }

        StringBuilder answer = new StringBuilder(N*2);
        dfs(graph, visited, answer, V);
        System.out.println(answer.toString());

        visited = new boolean[N + 1];
        answer = new StringBuilder(N * 2);
        bfs(graph, visited, answer, V);
        System.out.println(answer.toString());
    }

    private static void dfs(int[][] graph, boolean[] visited, StringBuilder answer, int start) {
        if (!visited[start]) {
            visited[start] = true;
            answer.append(start + " ");
            for (int to = 1; to < graph[start].length; to++) {
                if (!visited[to] && graph[start][to] == 1) {
                    dfs(graph, visited, answer, to);
                }
            }
        }
    }

    private static void bfs(int[][] graph, boolean[] visited, StringBuilder answer, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int from = q.poll();
            if (!visited[from]) {
                visited[from] = true;
                answer.append(from + " ");
                for (int to = 1; to < graph[from].length; to++) {
                    int toStatus = graph[from][to];
                    if (toStatus == 1 && !visited[to]) {
                        q.add(to);
                    }
                }
            }
        }
    }
}
