import java.io.*;
import java.util.*;

public class Main {
    static int cnt = 0;                     // 결과값을 담을 변수
    static boolean[] visited;
    static ArrayList<Integer>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        arr = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {                       // 인접 리스트에 그래프 데이터 저장.
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
                                                            // 무방향(양방향)이므로 입력받은 노드들을 서로 연결.
            arr[S].add(E);
            arr[E].add(S);
        }

        for(int i = 1; i <= N; i++) {                   // 결국 노드 하나씩 검사를 해볼 수 없겠다라는 결론으로 N 만큼 검사.
            if(!visited[i]) {
                bfs(i);
            }
        }

        System.out.println(cnt);
    }

    private static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(node);                                // 큐에 노드인 1을 넣음.
        visited[node] = true;
        cnt++;                                          // bfs는 너비 우선 탐색이라, 연결된 것들을 묶음 하나씩으로 파악하기 위해서, 여기서 카운트.

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i : arr[now]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

}
