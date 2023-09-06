import java.util.Scanner;

public class Seokjin {
    private static final char DIRECTION_RIGHT = 'R';
    private static final char DIRECTION_LEFT = 'L';
    private static final char DIRECTION_UP = 'U';
    private static final char DIRECTION_DOWN = 'D';

    static class Line {
        private int x;
        private int y;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 정사각형 길이
        int M = sc.nextInt(); // 반직선 개수
        long result = 0;
        Line[][] line = new Line[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int l = 1; l <= N; l++)
                line[i][l] = new Line();
        }

        for (int l = 0; l < M; l++) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            String direction = sc.next();

            switch (direction.charAt(0)) {
                case DIRECTION_LEFT:
                    for (int i = col; i >= 1; i--)
                        line[row][i].setX(line[row][i].getX() + 1);
                    break;

                case DIRECTION_RIGHT:
                    for (int i = col; i <= N; i++)
                        line[row][i].setX(line[row][i].getX() + 1);
                    break;

                case DIRECTION_UP:
                    for (int i = row; i >= 1; i--)
                        line[i][col].setY(line[i][col].getY() + 1);
                    break;

                case DIRECTION_DOWN:
                    for (int i = row; i <= N; i++)
                        line[i][col].setY(line[i][col].getY() + 1);
                    break;
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int l = 1; l <= N; l++)
                result += ((long) line[i][l].getX() * line[i][l].getY());
        }

        System.out.println(result);
    }
}