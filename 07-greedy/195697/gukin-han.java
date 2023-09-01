import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer line = new StringTokenizer(br.readLine());
		
		// parsing the first line containing num of fruits and budget
		int numOfFruits = Integer.parseInt(line.nextToken());
		int budget = Integer.parseInt(line.nextToken());
		// List<Fruit> fruits = new ArrayList<>();
		PriorityQueue<Fruit> fruits = new PriorityQueue<>();
		
		for(int i = 0; i < numOfFruits; i++) {
			line = new StringTokenizer(br.readLine());
			
			// parse
			int price = Integer.parseInt(line.nextToken());
			int carbs = Integer.parseInt(line.nextToken());
			
			fruits.add(new Fruit(price, carbs));
		}
		
		Long answer = 0L;
		// Collections.sort(fruits);
		while (budget != 0) {
			if (fruits.peek().amount == 0) fruits.poll();
			if (fruits.isEmpty()) break;
			
			// buy whole 
			if (fruits.peek().amount <= budget) {
				budget -= fruits.peek().amount;
				answer += fruits.peek().amount * fruits.peek().carbs;
				fruits.peek().amount = 0;
			} else { // buy pieces
				budget--;
				answer += fruits.peek().carbs;
				fruits.peek().amount--;
			}
			
		}
		
		System.out.println(answer);
	}
	
	private static class Fruit implements Comparable<Fruit>{
		private int price;
		private int amount;
		private int carbs;
		
		public Fruit(int price, int carbs) {
			this.price = 1;
			this.amount = price;
			this.carbs = carbs/price;
		}
		
		@Override
		public int compareTo(Fruit o) {
			return o.carbs - this.carbs;
		}
	}
}
