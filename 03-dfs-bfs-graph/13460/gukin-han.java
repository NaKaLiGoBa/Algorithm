import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(line.nextToken());
        int M = Integer.parseInt(line.nextToken());

        char[][] board = new char[N][M];
        for (int i = 0; i < board.length; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int bRow = 0;
        int bCol = 0;
        int rRow = 0;
        int rCol = 0;
        int oRow = 0;
        int oCol = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'B') {
                    bRow = i;
                    bCol = j;
                    board[i][j] = '.';
                } else if (board[i][j] == 'R') {
                    rRow = i;
                    rCol = j;
                    board[i][j] = '.';
                } else if (board[i][j] == 'O') {
                    oRow = i;
                    oCol = j;
                }
            }
        }


        int[] dRow = new int[]{0, 0, -1, 1}; // 좌우상하
        int[] dCol = new int[]{-1, 1, 0, 0};

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{rRow, rCol, bRow, bCol, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[4] >= 10) {
                System.out.println(-1);
                return;
            };

            for (int i = 0; i < 4; i++) {
                boolean bInHole = false;
                boolean rInHole = false;
                int curRRow = cur[0];
                int curRCol = cur[1];
                int curBRow = cur[2];
                int curBCol = cur[3];
                int curDistance = cur[4];

                // B가 R이 가려는 방향 앞쪽에 있는 경우
                if (i == 0 && curBCol < curRCol ||
                        i == 1 && curRCol < curBCol ||
                        i == 2 && curBRow < curRRow ||
                        i == 3 && curRRow < curBRow) {

                    while (board[curBRow][curBCol] == '.') {
                        curBRow += dRow[i];
                        curBCol += dCol[i];
                    }

                    if (board[curBRow][curBCol] == 'O') bInHole = true;
                    else if (board[curBRow][curBCol] == '#') {
                        curBRow -= dRow[i];
                        curBCol -= dCol[i];
                    }

                    while (board[curRRow][curRCol] == '.' &&
                            !(curRRow == curBRow && curRCol == curBCol)) {
                        curRRow += dRow[i];
                        curRCol += dCol[i];
                    }

                    if (board[curRRow][curRCol] == 'O') rInHole = true;
                    else { // # 을 만나거나 B를 만나거나
                        curRRow -= dRow[i];
                        curRCol -= dCol[i];
                    }

                    if (bInHole) {
                        continue;
                    } else if (rInHole) {
                        System.out.println(curDistance + 1);
                        return;
                    } else {
                        q.offer(new int[]{curRRow, curRCol, curBRow, curBCol, curDistance + 1});
                    }

                } else { // B가 R이 가려는 방향에 없는 경우
                    while (board[curRRow][curRCol] == '.') {
                        curRRow += dRow[i];
                        curRCol += dCol[i];
                    }

                    if (board[curRRow][curRCol] == 'O') rInHole = true;
                    else if (board[curRRow][curRCol] == '#') {
                        curRRow -= dRow[i];
                        curRCol -= dCol[i];
                    }

                    while (board[curBRow][curBCol] == '.' &&
                            !(curRRow == curBRow && curRCol == curBCol)) {
                        curBRow += dRow[i];
                        curBCol += dCol[i];
                    }

                    if (board[curBRow][curBCol] == 'O') bInHole = true;
                    else { // # 을 만나거나 R을 만나거나
                        curBRow -= dRow[i];
                        curBCol -= dCol[i];
                    }

                    if (bInHole) {
                        continue;
                    } else if (rInHole) {
                        System.out.println(curDistance + 1);
                        return;
                    } else {
                        q.offer(new int[]{curRRow, curRCol, curBRow, curBCol, curDistance + 1});
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
