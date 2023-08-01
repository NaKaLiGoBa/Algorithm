import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;


public class Main {

    private static List<Character> chars = new ArrayList<>();
    private static List<String> answers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken()); // the number of password
        int C = Integer.parseInt(st.nextToken()); // the number of given alphabet

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            chars.add(st.nextToken().charAt(0));
        }
        Collections.sort(chars);
        boolean[] visited = new boolean[C];
        dfs(L, C, 0, visited, new ArrayList<Character>());

        answers = answers.stream().distinct().collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answers.size(); i++) {
            sb.append(answers.get(i));
            if (i < answers.size() - 1) sb.append("\n");
        }
        System.out.println(sb.toString());

    }

    private static void dfs(int L, int C, int start,boolean[] visited, List<Character> password) {
        if (password.size() == L) {
            if (validPassword(password)) {
                Collections.sort(password);
                StringBuilder sb = new StringBuilder();
                for (Character ch : password) {
                    sb.append(ch);
                }
                answers.add(sb.toString());
            }
            return;
        }
        for (int i = start; i < C; i++) {
            if (!visited[i]) {
                password.add(chars.get(i));
                visited[i] = true;
                dfs(L, C, i + 1, visited, password);
                visited[i] = false;
                password.remove(password.size() - 1);
            }
        }

    }

    private static boolean validPassword(List<Character> password) {
        int aeiouCount = 0;
        int nonAeiouCount = 0;
        for (char p : password) {
            if (isAEIOU(p)) aeiouCount++;
            else nonAeiouCount++;
        }
        return (aeiouCount >= 1 && nonAeiouCount >=2);
    }

    private static boolean isAEIOU(Character givenChar) {
        char[] aeiou = new char[]{'a', 'e', 'i', 'o', 'u'};
        for (char ch : aeiou) {
            if (ch == givenChar) return true;
        }
        return false;
    }
}
