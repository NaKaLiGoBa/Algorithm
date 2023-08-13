import java.io.*;
import java.util.*;
import java.util.LinkedList;

public class Main {


    private static List<List<Integer>> links;
    private static int[] target;
    private static boolean found = false;
    private static int answer = -1;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfPeople = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        target = new int[2];
        target[0] = Integer.parseInt(st.nextToken()) - 1;
        target[1] = Integer.parseInt(st.nextToken()) - 1 ;

        int numOfLink = Integer.parseInt(br.readLine());
        links = new ArrayList<>();
        for (int i = 0; i < numOfPeople; i++) {
            links.add(new ArrayList<>());
        }

        for (int i = 0; i < numOfLink; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;

            links.get(from).add(to);
            links.get(to).add(from);
        }
        visited = new boolean[numOfPeople];
        dfs(0, target[0]);
        System.out.println(answer);
    }

    private static void dfs(int currentDegree, int startFrom) {

        if (startFrom == target[1]) {
            answer = currentDegree;
            found = true;
            return ;
        }

        visited[startFrom] = true;

        for (Integer to : links.get(startFrom)) {
            if (visited[to]) continue;
            dfs(currentDegree + 1, to);
            if (found) return;
        }
    }

}
