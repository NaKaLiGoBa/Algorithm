import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Seokjin {
    static int n, k, q;
    static char[][] arr;
    static boolean[][] visited;
    // 상 하 좌 우
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {1, -1, 0, 0};
    static final int dirCnt = 4;

    static ArrayList<Space> connectedSpace;

    static class Space {
        private int y;
        private int x;

        public Space(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }
    }

    public static void deleteConnection(int y, int x, char ch) {
        Queue<Space> queue = new LinkedList<>();
        arr[y][x] = ch;
        visited = new boolean[n+2][n+2];
        connectedSpace = new ArrayList<>();

        queue.add(new Space(y, x));
        visited[y][x] = true;
        connectedSpace.add(new Space(y, x));

        while(!queue.isEmpty()) {
            Space cur = queue.poll();
            visited[cur.getY()][cur.getX()] = true;

            for(int i=0; i<dirCnt; i++) {
                int nextY = cur.getY() + dirY[i];
                int nextX = cur.getX() + dirX[i];

                if(!visited[nextY][nextX]
                        && (nextY>=1 && nextY<=n)
                        && (nextX>=1 && nextX<=n)
                        && arr[nextY][nextX] == ch) {
                    Space next = new Space(nextY, nextX);
                    queue.add(next);
                    connectedSpace.add(next);
                    visited[nextY][nextX] = true;
                }
            }
        }

        if(connectedSpace.size() >= k) {
            for(Space cur : connectedSpace)
                arr[cur.getY()][cur.getX()] = '.';
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 배열의 크기
        k = sc.nextInt(); // 연결 요소를 지울 기준
        q = sc.nextInt();
        arr = new char[n+2][n+2];
        visited = new boolean[n+2][n+2];
        connectedSpace = new ArrayList<>();

        sc.nextLine();

        for(int i=1; i<=n; i++) {
            String str = sc.nextLine();

            for(int l=0; l<n; l++)
                arr[i][l+1] = str.charAt(l);
        }

        for(int i=0; i<q; i++) {
            int y = sc.nextInt();
            int x = sc.nextInt();
            String d = sc.next();

            deleteConnection(y, x, d.charAt(0));
        }

        // 출력
        for(int i=1; i<=n; i++) {
            for(int l=1; l<=n; l++)
                System.out.print(arr[i][l]);
            System.out.println();
        }
    }
}