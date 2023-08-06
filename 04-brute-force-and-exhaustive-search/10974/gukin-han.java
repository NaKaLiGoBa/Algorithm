import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    private static int[] array;
    private static int N;
    private static boolean[] visited;
    private static List<Integer> temp = new ArrayList<>();
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        visited = new boolean[N];
        array = IntStream.rangeClosed(1, N).toArray();
        permutation(0);
        System.out.println(answer.toString());
    }

    private static void permutation(int numOfElement) {
        if (numOfElement == N) {
            for (int i = 0; i < temp.size(); i++) {
                answer.append(temp.get(i)).append(" ");
            }
            answer.append("\n");
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp.add(i + 1);
                permutation(numOfElement + 1);
                visited[i] = false;
                temp.remove(temp.size() - 1);
            }
        }

    }
}
