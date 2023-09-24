import java.io.*;
import java.util.*;
public class Main {
    private static StringBuilder answer = new StringBuilder();
    private static int[][] frame;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        frame = new int[N][N];
        for (int i = 0; i < frame.length; i++) {
            frame[i] = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        recursive(0, 0, N);
        System.out.println(answer.toString());
    }

    private static void recursive(int startY, int startX, int size) {


        int firstOne = frame[startY][startX];
        boolean consistent = true;
        for (int y = startY; y < startY + size; y++) {
            if (!consistent) break;
            for (int x = startX; x < startX + size; x++) {
                if (firstOne != frame[y][x]) {
                    consistent = false;
                    break;
                }
            }
        }

        if (consistent) {
            answer.append(firstOne);
            return;
        }

        if (!consistent && size <= 2) {
            answer.append("(");
            for (int y = startY; y < startY + size; y++) {
                for (int x = startX; x < startX + size; x++) {
                    answer.append(frame[y][x]);
                }
            }
            answer.append(")");
        }

        if (!consistent && size > 2) {
            int newSize = size/2;
            answer.append("(");
            recursive(startY,startX,newSize);
            recursive(startY,startX + newSize,newSize);
            recursive(startY + newSize, startX,newSize);
            recursive(startY + newSize,startX + newSize,newSize);
            answer.append(")");
        }

        return;
    }
}
