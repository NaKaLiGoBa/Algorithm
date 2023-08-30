import java.io.*;
import java.util.*;

class Main {
	
	private static int biggestTown = 0;
	private static int sizeOfTown;
	private static int criteria;
	private static int[][] town;
	private static int[] dRow = new int[]{1, -1, 0, 0};
	private static int[] dCol = new int[]{0, 0, 1, -1};
	private static int[] sizeOfType;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer line = new StringTokenizer(br.readLine());
		
		// get and parse first input
		sizeOfTown = Integer.parseInt(line.nextToken());
		criteria = Integer.parseInt(line.nextToken());
		sizeOfType = new int[51];
		
		// get and parse the village maps
		town = new int[sizeOfTown][sizeOfTown];
		for (int row = 0; row < town.length; row++) {
			line = new StringTokenizer(br.readLine());
			for (int col = 0; col < town[row].length; col++) {
				town[row][col] = Integer.parseInt(line.nextToken());
			}
		}
		
		// do exhaustive search by bfs
		for (int row = 0; row < town.length; row++) {
			for (int col = 0; col < town[row].length; col++) {
				if (town[row][col] == 0) continue;
				int targetType = town[row][col];
				town[row][col] = 0;
				int size = bfs(row, col, targetType);
				if (size < criteria) continue;
				sizeOfType[targetType]++;
			}
		}
		
		// get Type with max num of village;
		for (int i = sizeOfType.length-1; i >= 0; i-- ) {
			if (sizeOfType[biggestTown] < sizeOfType[i]) {
				biggestTown = i;
			}
		}
		
		System.out.println(biggestTown);
	}
	
	// define bfs
	private static int bfs (int row, int col, int targetType) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{row, col});
		int houseCount = 1;
		
		while(!q.isEmpty()) {
			int[] rowAndCol = q.poll();
			int curRow = rowAndCol[0];
			int curCol = rowAndCol[1];
			
			for (int i = 0; i < 4; i++) {
				int newRow = curRow + dRow[i];
				int newCol = curCol + dCol[i];
				
				if(newRow < 0 || newCol < 0 || newRow >= sizeOfTown || newCol >= sizeOfTown || town[newRow][newCol] != targetType) continue;
				town[newRow][newCol] = 0;
				houseCount++;
				q.add(new int[]{newRow, newCol});
			}
		}
		return houseCount;
	}
	
	
	
	
	
	
	
	
}
