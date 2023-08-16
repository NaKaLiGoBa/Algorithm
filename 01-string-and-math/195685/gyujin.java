import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int sum = 0;
		
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			
			int firstNum = Integer.parseInt(st.nextToken());
			String oper = st.nextToken();
			int secondNum = Integer.parseInt(st.nextToken());
			
			switch (oper) {
				
				case "+" : sum += (firstNum + secondNum); break;
				case "-" : sum += (firstNum - secondNum); break;
				case "*" : sum += firstNum * secondNum; break;
				case "/" :
					if (firstNum > 0) {
						sum += firstNum / secondNum;
					}
					break;		
				}
			}
		
		System.out.println(sum);
	}
}