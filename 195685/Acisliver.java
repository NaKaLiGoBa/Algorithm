import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int answer = 0;
		while(T-- > 0) {
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[2]);
			String operator = input[1];
			
			switch (operator) {
				case "+":
					answer += a + b;
					break;
				case "-":
					answer += a - b;
					break;
				case "*":
					answer += a * b;
					break;
				case "/":
					answer += a / b;
					break;
				default:
					throw new AssertionError();
			}
		}
		
		
		System.out.println(answer);
	}
}
