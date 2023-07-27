import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[][] maze;
    private static int N;
    private static int M;
    private static int minStep = Integer.MAX_VALUE;
    private static int[] dRow = {1, -1, 0, 0};
    private static int[] dCol = {0, 0, 1, -1};
    private static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new int[N][M];

        inputTo2DArray(br);
//        dfs(0, 0, 0);
        bfs();
        System.out.println(minStep);
    }

    private static void bfs() {

        q.add(new int[]{0, 0, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curRow = cur[0];
            int curCol = cur[1];
            maze[curRow][curCol] = 0;
            int currentStep = cur[2] + 1;

            if (curRow == N - 1 && curCol == M - 1 && minStep > currentStep) {
                minStep = currentStep;
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int newRow = cur[0] + dRow[i];
                int newCol = cur[1] + dCol[i];
                if (newRow >= 0 && newRow < N && newCol >= 0 && newCol < M && maze[newRow][newCol] == 1) {
                    q.add(new int[]{newRow, newCol, currentStep});
                    maze[newRow][newCol] = 0;
                }
            }

        }
    }

    private static void dfs(int curRow, int curCol, int curStep) {
        maze[curRow][curCol] = 0;
        curStep++;

        //reach the target
        if (curRow == N - 1 && curCol == M - 1 && minStep > curStep) {
            minStep = curStep;
            return;
        }

        //didn't reach the target
        for (int i = 0; i < 4; i++) {
            int newRow = curRow + dRow[i];
            int newCol = curCol + dCol[i];
            if (newRow >= 0 && newRow < N && newCol >= 0 && newCol < M && maze[newRow][newCol] == 1) {
                dfs(newRow, newCol, curStep);
                maze[newRow][newCol] = 1;
            }
        }
    }


    private static void inputTo2DArray(BufferedReader br) throws IOException {
        for (int row = 0; row < N; row++) {
            String rowString = br.readLine();
            for (int col = 0; col < M; col++) {
                maze[row][col] = (int) (rowString.charAt(col) - '0');
            }
        }
    }
}
