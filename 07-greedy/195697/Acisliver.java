import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		PriorityQueue<int[]> fruits = new PriorityQueue<>((a, b) -> (b[1] / b[0]) - (a[1] / a[0]));
		long answer = 0;
		
		while (N-- > 0) {
			int[] ints = Arrays.stream(br.readLine().split(" "))
											.mapToInt(Integer::parseInt)
											.toArray();
			fruits.add(ints);
		}
		
		while (K > 0 && !fruits.isEmpty()) {
			int[] fruit = fruits.poll();
			int P = fruit[0];
			int C = fruit[1];
			// System.out.printf("P: %d, C: %d\n", P, C);
			
			if (P > K) {
				answer += C / P * K;
				K = 0;
				continue;
			}
			answer += C;
			K -= P;
		}
		
		System.out.println(answer);
	}
}

