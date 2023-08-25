package groom;

import java.io.*;
import java.util.*;

class Main {
    static int N;
    static String[][] BOARD;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] goorm = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .map(i -> i - 1)
                .toArray();
        int[] player = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .map(i -> i - 1)
                .toArray();
        BOARD = new String[N][N];

        for (int i = 0; i < N; i++) {
            BOARD[i] = br.readLine().split(" ");
        }

        int g = play(goorm);
        int p = play(player);

        if (g == p) throw new AssertionError();

        System.out.println(p > g ? "player " + p : "goorm " + g);
    }

    private static int play(int[] pos) {
        boolean[][] visited = new boolean[N][N];
        visited[pos[0]][pos[1]] = true;
        int count = 1;
        return count + move(pos, visited);
    }

    private static int move(int[] pos, boolean[][] visited) {
        int result = 0;
        int y = pos[0];
        int x = pos[1];

        String cc = BOARD[y][x];
        int count = Integer.parseInt(cc.substring(0, cc.length() - 1));
        char command = cc.charAt(cc.length() - 1);

        int nY = y;
        int nX = x;

        while (count > 0) {
            switch (command) {
                case 'U' -> {
                    nY -= 1;
                    nY = nY < 0 ? N - 1 : nY;
                }
                case 'D' -> {
                    nY += 1;
                    nY = nY >= N ? 0 : nY;
                }
                case 'L' -> {
                    nX -= 1;
                    nX = nX < 0 ? N - 1 : nX;
                }
                case 'R' -> {
                    nX += 1;
                    nX = nX >= N ? 0 : nX;
                }
                default -> {
                }
            }
            if (visited[nY][nX]) {
                return result;
            }
            visited[nY][nX] = true;
            result += 1;
            count -= 1;
        }

        return result + move(new int[]{nY, nX}, visited);
    }

}

