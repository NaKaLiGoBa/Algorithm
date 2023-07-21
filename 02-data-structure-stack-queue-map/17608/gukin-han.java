import java.io.*;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            stack.add(Integer.parseInt(br.readLine()));
        }

        int max = 0;
        int answer = 0;
        while (!stack.isEmpty()) {
            int tempMax = stack.pop();
            if (tempMax > max) {
                answer++;
                max = tempMax;
            }
        }
        System.out.println(answer);
    }
}
