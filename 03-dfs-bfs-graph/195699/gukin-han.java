import java.io.*;
import java.util.*;
class Main {
    private static int N, M;
    private static List<Component> components = new ArrayList<>();
    private static List<List<Integer>> adjArr = new ArrayList<>();
    private static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line = new StringTokenizer(br.readLine());
        N = Integer.parseInt(line.nextToken());
        M = Integer.parseInt(line.nextToken());
        visited = new boolean[N + 1];

        for (int i = 0; i < N + 1; i++) {
            adjArr.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < M; i++) {
            line = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(line.nextToken());
            int b = Integer.parseInt(line.nextToken());

            adjArr.get(a).add(b);
            adjArr.get(b).add(a);
        }

        for (int node = 1; node < N; node++){
            if (visited[node]) continue;
            Component component = new Component(node);
            int numLink = findLink(node, component);
            Collections.sort(component.computers);
            component.lineNum = numLink/2;
            component.minNum = component.computers.get(0) + 1;
            component.density = component.lineNum / (double) component.size;
            components.add(component);
        }

        Collections.sort(components);
        System.out.println(components.get(0).toString());
    }

    private static int findLink(int node, Component component) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        int numLink = 0;

        while(!q.isEmpty()) {
            int from = q.poll();
//            component.add(from);
            visited[from] = true;

            for (int to: adjArr.get(from)) {
                numLink++;
                if (visited[to]) continue;
                component.add(to);
                visited[to] = true;
                q.add(to);
            }
        }
        return numLink;
    }

    private static class Component implements Comparable<Component>{
        public List<Integer> computers = new ArrayList<>();
        public long size = 0;
        public long minNum = Integer.MAX_VALUE;
        public long lineNum;
        public double density;

        public Component(int node) {
            computers.add(node);
            size++;
            lineNum = 0;
            density = 0;
        }

        public void add(Integer computer) {
//            if (!computers.contains(computer)) {
                computers.add(computer);
                size = computers.size();
//            }
            lineNum++;
        }

        @Override
        public int compareTo(Component o) {
            if (this.density != o.density) {
                if (this.density < o.density) return 1;
                else return -1;
            } else {
                if (this.size != o.size) {
                    return (int) (this.size - o.size);
                } else {
                    return (int) ( this.minNum - o.minNum);
                }
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int computer: computers) {
                sb.append(computer).append(" ");
            }
            return sb.toString();
        }
    }
}
