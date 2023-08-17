import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int numOfIngredient = Integer.parseInt(br.readLine());
		int[] ingredients = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		boolean isGoingUp = true;
		int prev = 0;
		int answer = 0;
		
		for (int ingredient: ingredients) {
			if (isGoingUp) {
				if (ingredient >= prev) {
					answer += ingredient;
					prev = ingredient;
					continue;
				} else {
					isGoingUp = false;
				}
			}
			
			if (!isGoingUp) {
				if (ingredient <= prev) {
					answer += ingredient;
					prev = ingredient;
					continue;
				} else {
					answer = 0;
					break;
				}
			}
		}
		System.out.println(answer);
	}
}

