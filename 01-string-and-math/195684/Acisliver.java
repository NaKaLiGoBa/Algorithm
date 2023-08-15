import java.io.*;
class Main {
	
	static final int DAY = 24 * 60;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int T = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		long time = T * 60 + M;
		for (int i = 0; i < N; i++) {
			time += Integer.parseInt(br.readLine());
		}
		time %= DAY;
		long t = time / 60;
		long m = time % 60;
		System.out.printf("%d %d", t, m);
	}
}
