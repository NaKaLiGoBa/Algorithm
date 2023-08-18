import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] num = new int[N][2];
		int[] result = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			num[i][0] = Integer.parseInt(st.nextToken());
			num[i][1] = Integer.bitCount(num[i][0]); 
		}
		
		Arrays.sort(num, (a,b) -> (a[1] == b[1]) ? b[0] - a[0] : b[1] - a[1]);
		
		for(int i = 0; i < N; i++) {
			result[i] = num[i][0];
		}
	
		System.out.println(result[K - 1]);
	}
}