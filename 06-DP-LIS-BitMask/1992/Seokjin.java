import java.util.Scanner;

public class Seokjin {
    static int[][] arr;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n][n];
        sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String str = sc.next();

            for (int j = 0; j < str.length(); j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        quadTree(0, 0, n);
        System.out.println(sb);
    }

    public static void quadTree(int y, int x, int len) {
        if (isQuadTree(y, x, len)) {
            sb.append(arr[y][x]);
            return;
        } else {
            int halfLen = len / 2;

            // 왼쪽 위, 오른쪽 위, 왼쪽 아래, 오른쪽 아래 순서
            sb.append('(');
            quadTree(y, x, halfLen);
            quadTree(y, x + halfLen, halfLen);
            quadTree(y + halfLen, x, halfLen);
            quadTree(y + halfLen, x + halfLen, halfLen);
            sb.append(')');
        }
    }

    // 해당 영역의 값이 모두 동일한지 비교(하나라도 다르면 압축 불가)
    public static boolean isQuadTree(int y, int x, int len) {
        int dot = arr[y][x];

        for (int i = y; i < y + len; i++) {
            for (int j = x; j < x + len; j++) {
                if (dot != arr[i][j])
                    return false;
            }
        }

        return true;
    }
}