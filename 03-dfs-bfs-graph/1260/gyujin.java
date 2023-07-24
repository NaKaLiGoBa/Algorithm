import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<Integer>();          // 인접 리스트의 각 ArrayList 초기화
        }


        for(int i = 0; i < M; i++) {                    // 인접 리스트에 그래프 데이터를 저장하기 위함.
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());   
            int E = Integer.parseInt(st.nextToken());
                                                        // 무방향,양방향이므로 입력받은 에지들을 서로 연결.
            arr[S].add(E);      
            arr[E].add(S);
        }

        for(int i = 1; i <= N; i++) {
            Collections.sort(arr[i]);                   // 방문할 정점이 여러개인 경우, 정점 번호가 작은 것부터 먼저 가기위해 오름차순으로 정렬.
        }

        visited = new boolean[N + 1];                   // 방문한 각각의 정점들을 기억하기 위해 초기화
        dfs(V);
        sb.append('\n');
        visited = new boolean[N + 1];                   // dfs에서 저장한 것들을 다시 초기화.
        bfs(V);

        System.out.println(sb);
    }

    private static void dfs(int node) {
        visited[node] = true;                   // 먼저 방문한 정점부터 visited를 true로 해줌.

        sb.append(node).append(' ');
        for(int i : arr[node]) {                // 인접 리스트에 해당 노드와 연결된 노드를 하나씩 꺼냄.
            if(!visited[i]) {
                dfs(i);                         // 그 연결된 노드로 다시 재귀함수로 더 깊이 우선 탐색을 함.
            }
        }

    }

    private static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(node);                            // dfs와 달리 큐에 시작하는 정점부터 큐에 넣어 시작.
        visited[node] = true;

        sb.append(node).append(' ');

        while(!queue.isEmpty()) {                   // 여기서는 재귀호출이 아닌, 큐가 비어질때까지 반복.
            int now = queue.poll();                 // 연결된 노드들을 큐에 담아 하나씩 탐색할 것이므로 따로 변수에 담음.
            for(int i : arr[now]) {                 // 큐에 담긴 정점과 연결된 정점들을 하나씩 탐색.
                if(!visited[i]){
                    visited[i] = true;
                    sb.append(i).append(' ');
                    queue.add(i);                   // 한 정점으로부터 연결된 정점들부터 모두 탐색 후 또 그 연결된 정점들로부터 연결된 정점들을 탐색하므로 너비 우선 탐색.
                }
            }
        }

    }
}
