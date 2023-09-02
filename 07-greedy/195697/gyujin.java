import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());		// 과일의 개수
		int K = Integer.parseInt(st.nextToken());		// 돈
		long[] P = new long[N];
		long[] C = new long[N];
		// Integer[] calories = new Integer[N];
		// int[] count = new int[N];
		
		long[][] fullSlice = new long[N][2];
		
		for (int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			P[i] = Long.parseLong(st.nextToken());	// 각 과일의 가격
			C[i] = Long.parseLong(st.nextToken());	// 포만감
			
			fullSlice[i][0] = C[i] / P[i];			// 1원당 포만감
			fullSlice[i][1] = P[i];
		}
		
		Arrays.sort(fullSlice, (o1, o2) -> {
			return Long.compare(o2[0], o1[0]); 
		});
		 
		// Arrays.sort(calories, Collections.reverseOrder());
		
		long happy = 0;
		for (int i = 0 ; i < N && K > 0; i++) {
			int slice = (int) Math.min(K, fullSlice[i][1]);
			happy += slice * fullSlice[i][0];
			K -= slice;
		}
		
		System.out.println(happy);
	}
}