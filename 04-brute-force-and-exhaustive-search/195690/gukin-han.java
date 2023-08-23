import java.io.*;
class Main {
	
	private static final int[] ITEMS = new int[]{14, 7, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int damage = Integer.parseInt(br.readLine());
		int numOfItemsUsage = 0;
		
		for (int item:ITEMS) {
			numOfItemsUsage += (damage / item);
			damage %= item;
		}
		
		System.out.println(numOfItemsUsage);

	}
}
