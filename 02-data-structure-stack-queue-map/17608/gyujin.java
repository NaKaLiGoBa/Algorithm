import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 1;

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < N; i++) {
            stack.push(Integer.parseInt(br.readLine()));
        }

        int see = stack.pop();
        while(stack.size() > 0) {
            int behind = stack.pop();
            if (behind > see) {                             // 맨 앞에 있는 막대기보다 더 높은 막대기가 있다면,
                see = behind;                               // 그 뒤에 있는 것들을 거르기위함. 
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
