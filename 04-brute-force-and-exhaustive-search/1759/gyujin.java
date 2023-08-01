import java.io.*;
import java.util.*;

public class Main {
    static int L, C;
    static int collection, jaum;
    static char[] target, word;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        target = new char[L];
        word = new char[C];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i++) {
            word[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(word);
        comb(0, 0);

        System.out.println(sb);

    }

    private static void comb(int wordIdx, int targetIdx) {
        if (targetIdx == target.length) {
            for (int i = 0; i < L; i++) {
                if (target[i] == 'a' || target[i] == 'e' || target[i] == 'i' || target[i] == 'o' || target[i] == 'u') {
                    collection = 1;
                }else {
                    jaum++;
                }
            }

            if (collection == 1 && jaum >= 2) {
                for (int i = 0; i < L; i++) {
                    sb.append(target[i]);
                }
                sb.append('\n');
            }

            collection = 0;
            jaum = 0;
            return;
        }

        for (int i = wordIdx; i < word.length; i++) {
            target[targetIdx] = word[i];
            comb(i + 1, targetIdx + 1);
        }

    }
}


/*
import java.io.*;
import java.util.*;

public class Main {
    static int L;
    static Character[] dictionary;
    static StringBuilder words = new StringBuilder();
    static boolean[] visited;
    static ArrayList<Character> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        dictionary = new Character[C];
        visited = new boolean[C];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i++) {
            String str = st.nextToken();
            dictionary[i] = str.charAt(0);
        }

        Arrays.sort(dictionary);

        password(0, 0, 0);

        System.out.println(words);

    }

    private static void password(int depth, int moum, int jaum) {

        if (depth == L) {
            if (moum < 1 && jaum < 2) {
                System.out.println("아님");
                return;
            }
            for(char ch: list) {
                words.append(ch);
            }
            System.out.println(words + " 정답 ");
            words.append('\n');
            list.remove(L - 1);
            System.out.println("맞음" + depth + " d " + moum + " " + jaum);
            return;
        }

        for (int i = 0; i < dictionary.length; i++) {
            System.out.println("i : " + i);
            char ch = dictionary[i];
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                if(!visited[i]) {
                    list.add(ch);
                    visited[i] = true;
                    password(depth + 1, moum + 1, jaum);

                }
            }
            else {
                if (!visited[i]) {
                    list.add(ch);
                    visited[i] = true;
                    password(depth + 1, moum, jaum + 1);
                }
            }
        }

    }
}
*/
