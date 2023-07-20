import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {

            Queue<int[]> queue = new LinkedList<>();
            int cnt = 0;

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                queue.add(new int[] {j, Integer.parseInt(st.nextToken())});         // {초기위치, 중요도}
            }

            while (true) {
                int now[] = queue.poll();           // 큐에 저장된 가장 첫번째 원소를 꺼냄.    0 , 1
                boolean flag = true;                // now[] 에 담긴 우선순위보다 큐에 담겨있는 원소들 중 우선순위가 더 큰 것을 확인하기 위함.

                for(int q[] : queue) {              // 2 3 4 , 1
                    if(q[1] > now[1]) {             // 우선순위들끼리 비교
                        flag = false;
                        break;
                    }
                }

                if(flag) {
                    cnt++;                          // 큐에서 가장 우선순위가 큰 순서대로 cnt가 쌓임.
                    if(now[0] == M) break;          // 같은 원소들끼리 남았을 경우, M값에 해당하는 인덱스를 만날경우 break;
                }
                else {
                    queue.add(now);                 // 우선순위가 낮아 flag = falserk 가 되어, 큐의 맨 뒤로 보냄.
                }
            }
            sb.append(cnt).append('\n');
        }

        System.out.println(sb);
    }
}
