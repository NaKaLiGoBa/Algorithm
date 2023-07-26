import java.io.*;
import java.util.*;

public class Main {
    static int cnt;                                 // 결과값 도출위한 변수
    static int[] x = {0, 1, 0, -1};                 // 동남서북
    static int[] y = {1, 0, -1, 0};
    static boolean[][] complex, visited;            // 지도와 방문한 곳을 체크를 2차원 배열로.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        complex = new boolean[N][N];
        visited = new boolean[N][N];
        ArrayList<Integer> list = new ArrayList<>();                        // 동적인 단지의 수를 저장하기 위한 리스트.

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < str.length(); j++) {
                int temp = Integer.parseInt(str.substring(j, j + 1));       // String으로 받은 입력값을 하나씩 잘라서 temp로 저장.
                if (temp == 0) {                                            // 입력받은 값이 0이면 집이 없는 곳이니 다음으로.
                    continue;
                }
                complex[i][j] = true;                                       // 입력받은 값이 1이면 집이 있는 곳이므로 true.
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {                                    // 지도의 모든 곳을 체크.
                if(!visited[i][j] && complex[i][j]) {                       // 방문하지 않았고, 집이 있는 곳이라면
                    cnt = 1;                                                // 카운트를 1로 초기화 하고, dfs 호출
                    dfs(i, j);
                    list.add(cnt);                                          // 한 단지 수를 파악했으니 한 단지의 집의 수를 리스트에 저장.
                }
            }
        }

        Collections.sort(list);                                             // 리스트안에 들어있는 단지 내 집의 수를 오름차순으로 정렬.

        sb.append(list.size()).append('\n');                                // 총 단지 수 출력.
        for(int i : list) {
            sb.append(i).append('\n');
        }

        System.out.println(sb);
    }
    private static void dfs(int row, int col) {
        visited[row][col] = true;

        for(int i = 0; i < 4; i++) {
            int dx = row + x[i];                    // 현재 위치에서 동남서북 순으로 탐색.
            int dy = col + y[i];
            if (0 <= dx && 0 <= dy && dx < complex.length && dy < complex.length) {     // 지도의 크기를 벗어나면 안되므로.
                if(!visited[dx][dy] && complex[dx][dy]) {                               // 만약 방문하지 않았던 곳이고, 집이 있는 곳이라면
                    cnt++;                                                              // 카운트++;
                    dfs(dx,dy);                                                         // dfs 호출.
                }
            }
        }
    }

}
