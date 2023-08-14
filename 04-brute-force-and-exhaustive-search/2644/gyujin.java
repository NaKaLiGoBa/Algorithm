import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] list;
    static int humanA, humanB, result = 0;
    static int[] family;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        list = new ArrayList[n + 1];
        family = new int[n + 1];
        visited = new boolean[n + 1];

        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        humanA = Integer.parseInt(st.nextToken());
        humanB = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list[x].add(y);
            list[y].add(x);
        }

        calculate(humanA);

        System.out.println((result != 0) ? result : -1);
    }

    private static void calculate(int node) {
        Queue<Integer> queue = new LinkedList<>();

        visited[node] = true;
        family[node] = 0;

        queue.add(node);

        while(!queue.isEmpty()) {
            int new_node = queue.poll();
            if (new_node == humanB) {
                result = family[new_node];
                break;
            }

            for(int i : list[new_node]){
                if(!visited[i]) {
                    visited[i] = true;
                    family[i] = family[new_node] + 1;
                    queue.add(i);
                }
            }
        }
    }
}


