import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int[][] board = new int[9][9];
    private static List<List<Integer>> zeroPositions = new ArrayList<>();
    private static boolean found;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int row = 0; row < board.length; row++) {
            StringTokenizer rowElements = new StringTokenizer(br.readLine());
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = Integer.parseInt(rowElements.nextToken());
            }
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == 0) zeroPositions.add(List.of(row, col));
            }
        }

        solveSudoku(zeroPositions.size());

        StringBuilder answer = new StringBuilder();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                answer.append(board[row][col] + " ");
            }
            answer.append("\n");
        }
        System.out.println(answer);
    }

    private static void solveSudoku(int zeroCellCount) {
        if (zeroCellCount == 0) {
            found = true;
            return;
        }

        int curRow = zeroPositions.get(zeroCellCount - 1).get(0);
        int curCol = zeroPositions.get(zeroCellCount - 1).get(1);

        for (int candidate = 1; candidate <= 9; candidate++) {
            board[curRow][curCol] = candidate;
            if (promising(curRow, curCol)) solveSudoku(zeroCellCount - 1);
            if (found) return;
        }
        board[curRow][curCol] = 0;
    }

    private static boolean promising(int givenRow, int givenCol) {
        int givenElement = board[givenRow][givenCol];

        // check row and col
        for (int i = 0; i < board.length; i++) {
            if (i != givenCol && board[givenRow][i] == givenElement) return false;
            if (i != givenRow && board[i][givenCol] == givenElement) return false;
        }

        // check 3x3 diagonal element
//        int[] dRow = {1, 1, -1, -1, 1, -1, 0, 0};
//        int[] dCol = {1, -1, 1, -1, 0, 0, 1, -1};
//        for (int i = 0; i < dRow.length; i++) {
//            int newRow = givenRow + dRow[i];
//            int newCol = givenCol + dCol[i];
//            if (newRow >= 0 && newRow < 9 && newCol >= 0 && newCol < 9 && board[newRow][newCol] == givenElement) return false;
//        }
//        return true;

        // Check 3x3 box
        int startRow = givenRow / 3 * 3;
        int startCol = givenCol / 3 * 3;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (startRow + row == givenRow && startCol + col == givenCol) continue;
                if (board[startRow + row][startCol + col] == givenElement) return false;
            }
        }

        return true;
    }
}
