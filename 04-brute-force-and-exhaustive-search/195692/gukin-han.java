import java.io.*;
import java.util.*;
class Main {
	private static int goormScore = 0;
	private static int playerScore = 0;
	private static boolean[][] visited;
	private static String[][] board;
	private static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// set up variables needed
		N = Integer.parseInt(br.readLine());
		int[] goormRC = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] playerRC = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		board = new String[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().split(" ");
		}
		
		goormScore = playGameBy(goormRC);
		visited = new boolean[N][N];
		playerScore = playGameBy(playerRC);
		// System.out.println(goormScore + " " + playerScore);
		
		showResult();
	}
	
	private static int playGameBy(int[] startAt) {
		int row = startAt[0] - 1;
		int col = startAt[1] - 1;
		int score = 0;
		
		score++;
		visited[row][col] = true;
		
		int commandSize = board[row][col].length();
		int steps = Integer.parseInt(board[row][col].substring(0, commandSize-1));
		String direction = "" + board[row][col].charAt(commandSize - 1);
		
			
		while (steps > 0) {
			if (direction.equals("L")) col--;
			if (direction.equals("R")) col++;
			if (direction.equals("U")) row--;
			if (direction.equals("D")) row++;

			if (row < 0) row = N - 1;
			if (row >= N) row = 0;
			if (col < 0) col = N - 1;
			if (col >= N) col = 0;

			if (visited[row][col]) return score;
			score++;
			visited[row][col] = true;
			steps--;
			if (steps == 0) {
				commandSize = board[row][col].length();
				steps = Integer.parseInt(board[row][col].substring(0, commandSize-1));
				direction = "" + board[row][col].charAt(commandSize - 1);
			}
		}
			
		return score;
	}
	
	private static void showResult() {
		if (goormScore > playerScore) {
			System.out.println("goorm " + goormScore);
		} else {
			System.out.println("player " + playerScore);
		}
	}
}
