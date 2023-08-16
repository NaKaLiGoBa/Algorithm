import java.io.*;
class Main {
	private static int answer = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		parseInputAndGetAnswer(T, br);
		System.out.println(answer);
	}
	
	private static void parseInputAndGetAnswer(int T, BufferedReader br) throws Exception {
		
		for (int i = 0; i < T; i++) {
			String input = br.readLine();
			
			String[] elements =  input.split(" ");
			int int1 = Integer.parseInt(elements[0]);
			String operator = String.valueOf(elements[1]);
			int int2 = Integer.parseInt(elements[2]);
			
			switch(operator) {
				case "+": answer += int1 + int2; break;
				case "-": answer += int1 - int2; break;
				case "*": answer += int1 * int2; break;
				case "/": answer += int1 / int2; break;
			}
		}
	}
}
