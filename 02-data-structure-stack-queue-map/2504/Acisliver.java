package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

import static java.lang.System.in;

// 괄호의 값
// https://www.acmicpc.net/problem/2504
public class N2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        char[] str = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        int answer = 0;
        int temp = 1;
        boolean flag = false;

        for (char cur : str) {
            if (cur == '(' || cur == '[') {    // 여는 괄호일 경우 해당 temp에 숫자를 곱해둡니다.
                stack.push(cur);
                temp *= cur == '(' ? 2 : 3;
                flag = false;
                continue;
            }

            if (stack.isEmpty()) {
                System.out.println(0);
                return;
            }

            char prev = stack.pop();
            if (prev == '(') {            // 닫는 괄호일 경우 앞에서 곱해진 값들로 값이 정해집니다. ex) [[[] => 27
                if (cur != ')') {
                    System.out.println(0);
                    return;
                }
                if (flag) {               // 닫는 괄호가 연달아 올 경우 하나의 숫자가 여러번 더해져서 예외처리 했습니다. ex) [[[]] 에서 27을 이미 더했는데 9를 또 더하면 안됨
                    temp /= 2;
                    continue;
                }
                answer += temp;
                temp /= 2;
                flag = true;
            }
            if (prev == '[') {
                if (cur != ']') {
                    System.out.println(0);
                    return;
                }
                if (flag) {
                    temp /= 3;
                    continue;
                }
                answer += temp;
                temp /= 3;
                flag = true;
            }
        }

        if (!stack.isEmpty()) {        // 만약 스택에 값이 남아있다면 괄호가 정확하지 않는 것입니다.
            System.out.println(0);
            return;
        }

        System.out.println(answer);
    }

}

