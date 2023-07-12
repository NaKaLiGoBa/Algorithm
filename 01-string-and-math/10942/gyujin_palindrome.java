import java.io.*;
import java.util.*;

public class Main {
    static int[] numArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        numArr = new int[N + 1];                            // 인덱스를 맞추기 위해 N+1 크기 설정
        numArr[0] = -1;

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            if(isPalindrome(S, E)) sb.append(1).append('\n');
            else sb.append(0).append('\n');
        }

        System.out.println(sb);

    }

    private static boolean isPalindrome(int s, int e) {
        int es = e - s;

        if (es < 3) {                                       // 3개 이하 팰린드롬 검사
            if (es < 1 || numArr[s] == numArr[e]) {         // 하나인 경우와 3개일 때, 양 쪽 비교시 같은수 일때, true 반환
                return true;
            } return false;
        }

        int diff = (es + 1) / 2;                            // 홀수일 경우, 가운데 전까지.     // 짝수일 경우, 짝지어서 비교할 수 있도록.
        int idx = 0;
        for(int i = s; i <= s + diff; i++) {                // 시작점 s 부터 ~ s + 차이점까지
            if (numArr[i] != numArr[e - idx++]) {           // 시작점s와 끝점e 와 서로 비교하기 위해 idx 변수로 조절.
                return false;
            }
        }

        return true;
    }
}
