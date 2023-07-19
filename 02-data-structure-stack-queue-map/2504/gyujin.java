import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        int result = 0;
        int tmp = 1;

        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];

            if (ch == '(' || ch == '[') {
                stack.add(ch);
                tmp *= (ch == '(') ? 2 : 3;             // ch == 'c' 일 때, true : 2, false : 3
            }
            else {
                if (stack.isEmpty()) {                  
                    result = 0;
                    break;
                }
                else {                                  // 스택이 비어있지 않다는 건, 닫힌 괄호들이 들어갔다는 것, 그 외에는 result = 0 && break;
                    char preCh = stack.pop();           // 닫힌 괄호가 무엇인지 스택에서 꺼냄.
                    if (ch == ')') {                    
                        if (preCh != '(') {             
                            result = 0;
                            break;
                        }
                        if (arr[i - 1] == '(') {        // 짝지어서 나오는 괄호일 경우에만 결과값에 더함. 
                            result += tmp;
                        }
                        tmp /= 2;                       // 분배법칙의 포인트라고 생각.
                        }

                    else {
                        if (preCh != '[') {
                            result = 0;
                            break;
                        }
                        if (arr[i - 1] == '[') {
                            result += tmp;
                        }
                        tmp /= 3;
                    }
                }
            }
        }

        if(!stack.isEmpty()) {
            result = 0;
        }
        System.out.println(result);

    }
}
