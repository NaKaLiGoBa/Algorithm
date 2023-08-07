import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int cnt = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int computer = Integer.parseInt(br.readLine());
        int computer_pair = Integer.parseInt(br.readLine());

        list = new ArrayList[computer + 1];
        visited = new boolean[computer + 1];

        for(int i = 1; i <= computer; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < computer_pair; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[u].add(v);
            list[v].add(u);
        }

        bfs(1);

        System.out.println(cnt);
    }

    private static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        while(!queue.isEmpty()) {
            int new_node = queue.poll();
            for(int i : list[new_node]) {
                if(!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                    cnt++;
                }
            }
        }

    }
}


