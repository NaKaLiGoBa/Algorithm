import java.io.*;
import java.util.*;

class Main {
	private static final int BANDAGE = 1;
	private static final int MEDICINE = 7;
	private static final int PAINKILLER = 14;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		while (0 < N) {
			cnt += (N / PAINKILLER);
			N %= PAINKILLER;
			
			cnt += (N / MEDICINE);
			N %= MEDICINE;
			
			cnt += (N / BANDAGE);
			N %= BANDAGE;
		}
		
		System.out.println(cnt);
	}
}