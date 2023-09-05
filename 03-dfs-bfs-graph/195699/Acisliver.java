
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Main {

    static int N, M;
    static List<List<Integer>> NETWORK = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] ints = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        N = ints[0];
        M = ints[1];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            NETWORK.add(new ArrayList<>());
        }
        while (M-- > 0) {
            ints = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int a = ints[0] - 1;
            int b = ints[1] - 1;
            NETWORK.get(a).add(b);
            NETWORK.get(b).add(a);
        }

        List<Integer> answer = IntStream.range(0, N)
                .boxed()
                .collect(Collectors.toList());
        double maxDensity = -1;

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            List<Integer> component = new ArrayList<>();
            component.add(i);
            bfs(i, component);
            Collections.sort(component);
            double density = getDensity(component);
            if (density > maxDensity) {
                answer = component;
                maxDensity = density;
                continue;
            }
            if (density == maxDensity) {
                if (answer.size() > component.size()) {
                    answer = component;
                    continue;
                }
                if (answer.get(0) > component.get(0)) {
                    answer = component;
                }
            }
        }

        System.out.println(
                answer.stream()
                        .map(i -> i + 1)
                        .map(String::valueOf)
                        .collect(Collectors.joining(" "))
        );
    }

    private static double getDensity(List<Integer> component) {
        int computer = component.size();
        int line = component.stream()
                .map(NETWORK::get)
                .mapToInt(List::size)
                .sum();
        return (double) (line / 2) / computer;
    }

    private static void dfs(int cur, List<Integer> component) {
        for (Integer next : NETWORK.get(cur)) {
            if (visited[next]) continue;
            visited[next] = true;
            component.add(next);
            dfs(next, component);
        }
    }
    
    private static void bfs(int start, List<Integer> component) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (Integer next : NETWORK.get(cur)) {
                if (visited[next]) continue;
                visited[next] = true;
                component.add(next);
                queue.add(next);
            }
        }
    }

}


