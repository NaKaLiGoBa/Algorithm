import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] givenIntArray = Arrays.stream(br.readLine().split(" "))
																.mapToInt(Integer::parseInt)
																.toArray();
		
		List<NewInt> newInt = new ArrayList<>();
		for (int givenInt: givenIntArray) {
			newInt.add(new NewInt(givenInt));
		}
		
		Collections.sort(newInt);
		System.out.println(newInt.get(newInt.size() - K).getDec());
	}
	
	private static class NewInt implements Comparable<NewInt>{
		
		private int dec;
		private int binaryOneCount;
		
		
		public NewInt(int dec) {
			this.dec = dec;
			int oneCount = 0;
			
			int tempDec = dec;
			while (tempDec != 0) {
				oneCount += (tempDec % 2);
				tempDec /= 2;
			}
			this.binaryOneCount = oneCount;
		}
		
		@Override
		public int compareTo(NewInt other) {
			if (this.binaryOneCount < other.binaryOneCount) return -1;
			if (this.binaryOneCount > other.binaryOneCount) return 1;
			return Integer.compare(this.dec, other.dec);
		}
		
		
		public int getDec() {
			return this.dec;
		}
	}
}
