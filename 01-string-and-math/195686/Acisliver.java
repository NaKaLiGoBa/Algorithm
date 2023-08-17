import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] input = Arrays.stream(br.readLine().split(" "))
										.mapToInt(Integer::parseInt)
										.toArray();
		int answer = input[0];
		boolean isInc = true;
		for (int i = 1; i < N; i++) {
			answer += input[i];
			if (isInc && input[i - 1] > input[i]) {
				isInc = false;
				continue;
			} 
			if (!isInc && input[i - 1] < input[i]) {
				System.out.println(0);
				return;
			}
		}
		
		System.out.println(answer);
	}
}

