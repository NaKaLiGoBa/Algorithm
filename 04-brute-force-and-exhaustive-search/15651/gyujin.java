import java.io.*;
import java.util.*;

public class Main {
    private static int[] combi;
    private static int N, M;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        combi = new int[M];

        backtracking(0);

        System.out.println(sb);

    }
    private static void backtracking(int depth) {

        if (depth == M) {
            for(int i : combi) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i = 1; i <= N; i++) {
            combi[depth] = i;                           // 처음 생각할 때는 combi배열 크기가 M이고, for문은 N까지 돌아 인덱스를 어떻게 설정해야 되나 고민했는데, depth가 M까지 들어가 depth로 해결하였습니다.
            backtracking(depth + 1);
        }

    }
}
