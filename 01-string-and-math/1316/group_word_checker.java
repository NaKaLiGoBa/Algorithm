import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());         // N을 입력 (입력받을 단어 개수)
        int cnt = 0;                                            // 결과값을 담을 변수
        boolean[] check;                                        // 이미 지나친 알파벳인지 체크하는 그릇

        for(int i = 0; i < N; i++) {
            check = new boolean[26];                            // 아스키코드 a-z 을 담을 그릇을 단어마다 초기화
            int count = 0;                                      // 연속된 알파벳과 서로 다른 알파벳을 카운트할 변수
            int checker = 0;                                    // 연속된 알파벳
            String word = br.readLine().trim();

            for(int j = 0; j < word.length(); j++) {            // 단어의 알파벳만큼 반복
                int now = word.charAt(j);                       // for문에 따라 단어의 현재 알파벳을 가리키는 변수

                if(checker != now) {                            // 0으로 초기화되어 있어, 맨 처음 알파벳 or 다른 알파벳이 시작될 때.
                    if(check[now - 'a'] == false) {             // 처음 본 알파벳인지
                        check[now - 'a'] = true;                // 한번 봤으니 true로 변경
                        checker = now;                          // 알파벳이 바뀌었으니 바꿔줌
                        count++;
                    }
                    else count--;
                } else count++;
            }

           if(count == word.length()) {                         // 한 단어를 돌았을 시, 그 단어의 길이만큼 count 됐으면,
               cnt++;                                           // 그건 그룹단어.
           }
        }

        System.out.println(cnt);
    }
}
