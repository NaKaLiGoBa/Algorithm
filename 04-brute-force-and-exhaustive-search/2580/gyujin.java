import java.io.*;
import java.util.*;

public class Main {
    private static int[][] sudoku = new int[9][9];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++) {
                sudoku[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        search(0, 0);
    }

    private static void search(int row, int col) {

        if (col == 9) {                                             // '열'을 +1 씩 증가시켜 결국 9가 되면, '행'을 +1 해주고 다시 '열'을 0으로 해줌.
            search(row + 1, 0);
            return;
        }

        if (row == 9) {                                             // '행'이 9가 되었다는 것은 스도쿠의 값을 다 넣었다는 의미로 답 출력
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    sb.append(sudoku[i][j]).append(' ');
                }
                sb.append('\n');
            }
            System.out.println(sb);

            System.exit(0);                                 // 답이 여러개가 나올 수 있어 처음 답을 출력하기 위해 답 출력 후, 프로그램 자체를 종료.
        }

        if(sudoku[row][col] == 0) {                                 // 9*9 칸에서 0 발견 시, 1~9까지 검사를 함.

            for(int i = 1; i <= 9; i++) {                           // ******
                if(possibility(row, col, i)) {                      // * 부분이 백트래킹의 핵심 원리라고 생각..
                    sudoku[row][col] = i;                           // 값을 i값이 충족이 됐다면 일단 값을 넣고
                    search(row, col + 1);                       // 재귀를 반복.
                }
            }
            sudoku[row][col] = 0;                                   // possibility()에서 같은 값이 안나오면 True를 반환하는데, 만약 row, col, 3*3에서 0이 여러개라면 처음에 틀린 값을 넣었을 수 있어서 이렇게 다시 초기화하는 부분이 필요.
            return;                                                 
        }                                                          // ******

        search(row, col + 1);
    }

    private static boolean possibility(int row, int col, int goal) {

        for(int i = 0; i < 9; i++) {                                // '행'을 기준으로 '열'끼리 비교하여 위에서 1~9까지 값을 넣은 후, 같은 값이 있으면 false 반환.
            if(sudoku[row][i] == goal) {
                return false;
            }
        }

        for(int i = 0; i < 9; i++) {                                // '열'을 기준으로 '행'끼리 비교하여 위에서 1~9까지 값을 넣은 후, 같은 값이 있으면 false 반환.
            if(sudoku[i][col] == goal) {
                return false;
            }
        }

        int new_row = (row / 3) * 3;                                // 3*3 크기인 사각형 안에서도 비교를 해야 하므로, 맨 왼쪽 상단의 값을 지정하기 위함.
        int new_col = (col / 3) * 3;

        for(int i = new_row; i < new_row + 3; i++) {
            for(int j = new_col; j < new_col + 3; j++) {
                if(sudoku[i][j] == goal) {                          // 3*3 크기를 비교 후 같은 값이 있으면 false 반환.
                    return false;
                }
            }
        }
        return true;                                                // 위의 세 개의 조건을 충족하지 않다면 true 반환.
    }
}
