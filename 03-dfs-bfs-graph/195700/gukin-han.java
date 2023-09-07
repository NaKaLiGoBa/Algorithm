import java.io.*;
import java.util.*;

class Main {
	
	private static int N, M;
	private static StringBuilder[][] matrix;
	private static long totalNumOfPoints;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer line = new StringTokenizer(br.readLine());
		N = Integer.parseInt(line.nextToken());
		M = Integer.parseInt(line.nextToken());
		
		// Initialize all elements of matrix with new StringBuilder instances
		matrix = new StringBuilder[N][N];
		for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
						matrix[i][j] = new StringBuilder();
				}
		}
		
		// populate matrix
		for (int i = 0; i < M; i++) {
			line = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(line.nextToken()) - 1;
			int x = Integer.parseInt(line.nextToken()) - 1;
			String direction = line.nextToken();
			int[] start = new int[]{y, x};
			
			switch(direction) {
				case "R": goRightFrom(start); break;
				case "L": goLeftFrom(start); break;
				case "U": goUpFrom(start); break;
				case "D": goDownFrom(start); break;
			}
		}
		
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				String cur = matrix[row][col].toString();
				if (cur.equals("")) continue;
				if (cur.contains("V") && cur.contains("H")) getNumOfPoints(cur);
			}
		}
		
		System.out.println(totalNumOfPoints);
	}
	
	private static void getNumOfPoints(String cur) {
		long vCount = 0;
		long hCount = 0;
		
		for (char c: cur.toCharArray()) {
			if (c == 'H') hCount++;
			if (c == 'V') vCount++;
		}
		
		totalNumOfPoints += (vCount * hCount);
	}
	
	private static void goRightFrom(int[] start) {
		int y = start[0];
		int x = start[1];
		for (int dx = x; dx < N; dx++) {
			matrix[y][dx].append("H");
		}
	}
	
	private static void goLeftFrom(int[] start) {
		int y = start[0];
		int x = start[1];
		for (int dx = x; dx >= 0; dx--) {
			matrix[y][dx].append("H");
		}
	}
	
	private static void goDownFrom(int[] start) {
		int y = start[0];
		int x = start[1];
		for (int dy = y; dy < N; dy++) {
			matrix[dy][x].append("V");
		}
	}
			
	private static void goUpFrom(int[] start) {
		int y = start[0];
		int x = start[1];
		for (int dy = y; dy >= 0; dy--) {
			matrix[dy][x].append("V");
		}
	}
}
