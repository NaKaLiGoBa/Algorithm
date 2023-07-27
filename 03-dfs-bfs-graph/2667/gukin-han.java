import java.io.*;
import java.util.*;

public class Main {

    private static int[][] givenMap;
    private static int N;
    private static List<Integer> numOfHouseList = new ArrayList<>();
    private static int numOfHouse;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        givenMap = new int[N][N];

        inputTo2DArray(br);
        addNumOfHouseToList();
        printResult();
    }

    private static void inputTo2DArray(BufferedReader br) throws IOException {
        for (int row = 0; row < N; row++) {
            String rowString = br.readLine();
            for (int col = 0; col < N; col++) {
                givenMap[row][col] = (int) (rowString.charAt(col) - '0');
            }
        }
    }

    private static void addNumOfHouseToList() {
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                numOfHouse = 0;
                if (givenMap[row][col] == 1) {
                    dfs(row, col);
                    numOfHouseList.add(numOfHouse);
                }
            }
        }
    }

    private static void dfs(int row, int col) {
        givenMap[row][col] = 0;
        numOfHouse++;
        if (row - 1 >= 0 && givenMap[row-1][col] == 1) dfs(row - 1, col); // go up
        if (row + 1 < N && givenMap[row+1][col] == 1) dfs(row + 1, col); // go down
        if (col - 1 >= 0 && givenMap[row][col-1] == 1) dfs(row, col - 1); // go left
        if (col + 1 < N && givenMap[row][col+1] == 1) dfs(row, col + 1); // go right
        return;
    }

    private static void printResult() {
        Collections.sort(numOfHouseList);
        StringBuilder answer = new StringBuilder(numOfHouseList.size() + 1);
        answer.append(numOfHouseList.size() + "\n");
        for (int numOfHouse : numOfHouseList) {
            answer.append(numOfHouse + "\n");
        }
        System.out.println(answer.toString());
    }
}
