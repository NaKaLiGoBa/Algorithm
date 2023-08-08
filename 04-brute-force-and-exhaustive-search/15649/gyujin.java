import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static int[] numbers;
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        numbers = new int[M];

        backtracking(0);

        System.out.println(sb);

    }
    private static void backtracking(int depth) {

        if (M == depth) {
            for(int num : numbers) {
                sb.append(num).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                numbers[depth] = i;
                backtracking(depth + 1);
                visited[i] = false;
            }
        }


    }
}


