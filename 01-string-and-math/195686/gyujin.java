import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		int tasty = 0;
		boolean change = false;
		
		int[] ingredients = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			ingredients[i] = Integer.parseInt(st.nextToken());
			tasty += ingredients[i];
			if (i == 0) continue;
			if (ingredients[i] < ingredients[i - 1] && !change) {
				cnt++; 
				change = !change;
			}
			else if (ingredients[i - 1] < ingredients[i] && change) {
				cnt++;
				change = !change;
			}
		}
		
		tasty = (cnt <= 1) ? tasty : 0;  

		System.out.println(tasty);
	}
}