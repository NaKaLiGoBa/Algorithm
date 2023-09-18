import java.io.*;
import java.util.*;

public class Main {
    private static int[] x = {-1, 1, 0 ,0};
    private static int[] y = {0, 0, -1, 1};
    private static char[][] board;
    private static int Rcnt, Bcnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 세로
        int M = Integer.parseInt(st.nextToken());   // 가로

        board = new char[N][M];

        /**
         * . : 빈칸
         * # : 장애물 또는 벽
         * O : 구멍의 위치
         * R : 빨간 구슬
         * B : 파란 구슬
         */

        int RposX = 0;
        int RposY = 0;
        int BposX = 0;
        int BposY = 0;
        for (int i = 0; i < N; i++) {
            String ch = br.readLine();
            for(int j = 0; j < M; j++) {
                board[i][j] = ch.charAt(j);
                if (ch.charAt(j) == 'R') {
                    RposX = i;
                    RposY = j;
                }
                else if (ch.charAt(j) == 'B'){
                    BposX = i;
                    BposY = j;
                }
            }
        }

    }
    private static void gravity(int RX, int RY, int BX, int BY) {
        Queue<int[]> queueR = new LinkedList<>();
        Queue<int[]> queueB = new LinkedList<>();

        queueR.add(new int[] {RX, RY});
        queueB.add(new int[] {BX, BY});

        while(!queueR.isEmpty() || !queueB.isEmpty()) {




        }

    }
    private static void up(Queue<int[]> queueR, Queue<int[]> queueB) {
        int[] Rpos = queueR.poll();
        int[] Bpos = queueB.poll();

        if (Rpos[0] < Bpos[0]) {
            Rpos = moveUp(Rpos, Bpos);
            Bpos = moveUp(Bpos, Rpos);
        }
        else {
            Bpos = moveUp(Bpos, Rpos);
            Rpos = moveUp(Rpos, Bpos);
        }

        queueR.add(Rpos);
        queueB.add(Bpos);
    }
    private static int[] moveUp(int[] pos, int[] upPos) {
        while (true) {
            int nextX = pos[0] - 1;
            if (board[nextX][pos[1]] == '#' || (nextX == upPos[0] && pos[1] == upPos[1])) break;
            if (board[nextX][pos[1]] == 'O') {
                if (board[pos[0]][pos[1]] == 'R') Rcnt++;
                if (board[pos[0]][pos[1]] == 'B') Bcnt++;
                break;
            }
            pos[0] = nextX;
        }
        return pos;
    }
    private static void down(Queue<int[]> queueR, Queue<int[]> queueB) {
        int[] Rpos = queueR.poll();
        int[] Bpos = queueB.poll();

        if (Rpos[0] > Bpos[0]) {
            Rpos = moveDown(Rpos, Bpos);
            Bpos = moveDown(Bpos, Rpos);
        }
        else {
            Bpos = moveDown(Bpos, Rpos);
            Rpos = moveDown(Rpos, Bpos);
        }

        queueR.add(Rpos);
        queueB.add(Bpos);
    }
    private static int[] moveDown(int[] pos, int[] downPos) {
        while (true) {
            int nextX = pos[0] + 1;
            if (board[nextX][pos[1]] == '#' || (nextX == downPos[0] && pos[1] == downPos[1])) break;
            if (board[nextX][pos[1]] == 'O') {
                if (board[pos[0]][pos[1]] == 'R') Rcnt++;
                if (board[pos[0]][pos[1]] == 'B') Bcnt++;
                break;
            }
            pos[0] = nextX;
        }
        return pos;
    }
    private static void left(Queue<int[]> queueR, Queue<int[]> queueB) {
        int[] Rpos = queueR.poll();
        int[] Bpos = queueB.poll();

        if (Rpos[1] < Bpos[1]) {
            Rpos = moveLeft(Rpos, Bpos);
            Bpos = moveLeft(Bpos, Rpos);
        }
        else {
            Bpos = moveLeft(Bpos, Rpos);
            Rpos = moveLeft(Rpos, Bpos);
        }

        queueR.add(Rpos);
        queueB.add(Bpos);
    }
    private static int[] moveLeft(int[] pos, int[] leftPos) {
        while (true) {
            int nextY = pos[1] - 1;
            if (board[pos[0]][nextY] == '#' || (pos[0] == leftPos[0] && nextY == leftPos[1])) break;
            if (board[pos[0]][nextY] == 'O') {
                if (board[pos[0]][pos[1]] == 'R') Rcnt++;
                if (board[pos[0]][pos[1]] == 'B') Bcnt++;
                break;
            }
            pos[1] = nextY;
        }
        return pos;
    }
    private static void right(Queue<int[]> queueR, Queue<int[]> queueB) {
        int[] Rpos = queueR.poll();
        int[] Bpos = queueB.poll();

        if (Rpos[1] > Bpos[1]) {
            Rpos = moveRight(Rpos, Bpos);
            Bpos = moveRight(Bpos, Rpos);
        }
        else {
            Bpos = moveRight(Bpos, Rpos);
            Rpos = moveRight(Rpos, Bpos);
        }

        queueR.add(Rpos);
        queueB.add(Bpos);
    }

    private static int[] moveRight(int[] pos, int[] rightPos) {
        while (true) {
            int nextY = pos[1] + 1;
            if (board[pos[0]][nextY] == '#' || (pos[0] == rightPos[0] && nextY == rightPos[1])) break;
            if (board[pos[0]][nextY] == 'O') {
                if (board[pos[0]][pos[1]] == 'R') Rcnt++;
                if (board[pos[0]][pos[1]] == 'B') Bcnt++;
                break;
            }
            pos[1] = nextY;
        }
        return pos;
    }
}
