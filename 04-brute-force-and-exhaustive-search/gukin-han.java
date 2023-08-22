import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int boardSize = Integer.parseInt(input[0]);
		int targetNum = Integer.parseInt(input[1]);
		int[][] board = new int[boardSize][boardSize];
		int answer = 0;
		
		for (int row = 0; row < boardSize; row++) {
			String[] line = br.readLine().split(" ");
			for (int col = 0; col < line.length; col++) {
				board[row][col] = Integer.parseInt(line[col]);
			}
		}
		
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				if (board[row][col] == 1) continue;
				int numOfFlagsAtThisPosition = getNumOfFlags(board, row, col);
				if (numOfFlagsAtThisPosition == targetNum) answer++;
			}
		}
		
		System.out.println(answer);
	}
	
	private static int getNumOfFlags(int[][] board, int row, int col) {
		int[] dRow = new int[]{1, 1, 1, 0, 0, -1, -1, -1};
		int[] dCol = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
		
		int numOfFlags = 0;
		
		for (int i = 0; i < dRow.length; i++) {
			int rowToCheck = row + dRow[i];
			int colToCheck = col + dCol[i];
			
			// validate
			if (rowToCheck < 0 || colToCheck < 0 
					|| rowToCheck >= board.length 
					|| colToCheck >= board.length) continue;
			
			if (board[rowToCheck][colToCheck] == 1) numOfFlags++;
		}
		
		return numOfFlags;
	}
}
