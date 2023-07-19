import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String brackets = br.readLine();

        Stack<Character> stack = new Stack<>();

        int temp = 1;
        int answer = 0;

        for (int i = 0; i < brackets.length(); i++) {
            char currentBracket = brackets.charAt(i);

            if (currentBracket == '(') {
                stack.push(currentBracket);
                temp *= 2;
            } else if (currentBracket == '[') {
                stack.push(currentBracket);
                temp *= 3;
            } else if (currentBracket == ')') {
                if (stack.isEmpty() || stack.peek() == '[') {
                    answer = 0;
                    break;
                }

                char prev = brackets.charAt(i - 1);
                if (prev == '(') {
                    answer += temp;
                }
                temp /= 2;
                stack.pop();
            } else if (currentBracket == ']'){
                if (stack.isEmpty() || stack.peek() == '(') {
                    answer = 0;
                    break;
                }

                char prev = brackets.charAt(i - 1);
                if (prev == '[') {
                    answer += temp;
                }
                temp /= 3;
                stack.pop();
            }

        }
        if (!stack.isEmpty()) System.out.println(0);
        else System.out.println(answer);
    }
}


