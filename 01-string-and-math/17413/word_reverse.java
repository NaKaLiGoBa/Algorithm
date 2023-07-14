import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        String str = br.readLine().trim();

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);                    // 문자 하나하나씩 ch 변수에 저장.

            if (ch == '<') {                            // 태그가 시작하는 '<' 만났을 때
                while (!stack.isEmpty()) {              // 혹시라도 stack에 담긴게 하나라도 있으면, stack이 비워질때 까지.
                    sb.append(stack.pop());             // 스택에서 문자하나씩 지우고, StringBuilder 에 저장.
                }

                sb.append(ch);                          // '<'을 StringBuilder에 저장.
                while (ch != '>') {                     // 태그가 끝나는 '>' 만날 때까지 loop
                    i++;                                // while문을 사용하고 싶어서 for문의 i값을 사용.
                    ch = str.charAt(i);                 // '>' 만날 때까지 i를 증가시키면서 
                    sb.append(ch);                      // sb에 문자하나씩 저장.
                }
            }

            else {
                if (ch == ' ') {                        // 띄어쓰기를 만날때
                    while (!stack.isEmpty()) {          // 위와 똑같은 맥락.
                        sb.append(stack.pop());
                    }

                    sb.append(ch);                      // 띄어쓰기 StringBuilder에 저장.
                } 
                else {
                    stack.push(ch);                     // 띄어쓰기 만나기 전까지 stack에 문자 하나씩 넣음.
                }
            }

        }

        while (!stack.isEmpty()) {                      // 만약 마지막 단어가 끝나고, '<' 혹은 띄어쓰기가 뒤에 없으니
            sb.append(stack.pop());                     // 혹시라도 스택이 채워져있는 경우가 있어서 for문이 끝나면 stack 체크.
        }                                               // (ex. 태그가 아닌 단어로 끝날 경우.)

        System.out.println(sb);                         // StringBuilder 에 담겨있는 것들을 출력.
    }
}
