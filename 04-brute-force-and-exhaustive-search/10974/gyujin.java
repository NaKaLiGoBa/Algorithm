import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer> list = new ArrayList<>();
    static int N;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];

        number(0);

        System.out.println(sb);

    }
    private static void number(int depth) {
        if (depth == N) {
            for(int res : list) {
                sb.append(res).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                list.add(i);
                number(depth + 1);
                list.remove(depth);
                visited[i] = false;
            }
        }

    }
}
/*
import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer> list = new ArrayList<>();
    static int N;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];

        number(1, 0);

        System.out.println(sb);

    }

    private static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    private static void number(int start, int depth) {
        if (depth == N) {
            for(int res : list) {
                sb.append(res).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                list.add(i);
                number(start + 1, depth + 1);
                list.remove(depth);
                visited[i] = false;
            }
        }

    }
}*/

