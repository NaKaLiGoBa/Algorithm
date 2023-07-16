import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length; i++) {
            char ch = s[i];
            if (ch =='<') {
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                while(ch != '>') {
                    sb.append(ch);
                    ch = s[++i];
                }
                sb.append(ch);
            } else {
                if (ch == ' ') {
                    while(!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(ch);
                } else {
                    stack.push(ch);
                }
            }

        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());

    }
}
