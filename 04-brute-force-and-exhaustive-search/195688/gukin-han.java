import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String S = br.readLine();
		List<String[]> candidates = new ArrayList<>();
		List<String> scoreContainer = new ArrayList<>();
		
		for (int i = 0; i < S.length() - 2; i++) {
			for (int j = i + 2; j < S.length(); j++) {
				String[] candidate = new String[3];
				candidate[0] = S.substring(0,i+1); // first word
				candidate[1] = S.substring(i+1, j); // second word
				candidate[2] = S.substring(j); // second word
				
				candidates.add(candidate);
				
				for (String c:candidate) {
					if(!scoreContainer.contains(c)) scoreContainer.add(c);
				}
			}
		}
		
		Collections.sort(scoreContainer);
		int maxScore = 0;
		for (String[] candidate: candidates) {
			int tempScore = 0;
			for (String c: candidate) {
				tempScore += scoreContainer.indexOf(c) + 1;
			}
			maxScore = Math.max(maxScore, tempScore);
		}
		
		System.out.println(maxScore);
	}
}
