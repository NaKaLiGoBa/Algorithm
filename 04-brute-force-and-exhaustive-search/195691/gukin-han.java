import java.io.*;
import java.util.*;

class Main {
	// top -> bottom -> left -> right
	private static final int[] dRow = new int[]{-1, 1, 0, 0, 0};
	private static final int[] dCol = new int[]{0, 0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // length of board;
		int K = Integer.parseInt(st.nextToken()); // the number of bombs;
		List<String[]> board = new ArrayList<>();
		int[][] memo = new int[N][N];
		int[][] bombs = new int[K][2];
		
		// populate board
		for (int i = 0; i < N; i++) {
			board.add(br.readLine().split(" "));
		}
		
		// populate bombs
		for (int i = 0; i < K; i++) {
			String[] aBomb = br.readLine().split(" ");
			bombs[i][0] = Integer.parseInt(aBomb[0]) - 1;
			bombs[i][1] = Integer.parseInt(aBomb[1]) - 1;			
		}
		
		// update damage memo
		for (int[] aBomb: bombs) {
			updateBoard(aBomb, board, memo);
		}
		
		// get max from memo
		int maxDamage = 0;
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				int damage = memo[row][col];
				maxDamage = Math.max(maxDamage, damage);
			}
		}
		
		// return max damage
		System.out.println(maxDamage);
	}
	
	private static void updateBoard(int[] aBomb, List<String[]> board, int[][] memo) {
		// get y, x
		int row = aBomb[0];
		int col = aBomb[1];
		
		// update memo at y, x based on the state at
		for (int i = 0; i < 5; i++) {
			int rowToCheck = row + dRow[i];
			int colToCheck = col + dCol[i];
			
			if (rowToCheck >= 0 && rowToCheck < memo.length && 
					colToCheck >= 0 && colToCheck < memo.length) {
				String stateIs = board.get(rowToCheck)[colToCheck];
				
				
				switch (stateIs) {
					case "0": memo[colToCheck][rowToCheck] += 1; break;
					case "@": memo[colToCheck][rowToCheck] += 2; break;
					default: break;
				}
			}
		}
	}
}
