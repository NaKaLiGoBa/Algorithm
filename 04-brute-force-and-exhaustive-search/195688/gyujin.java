import java.io.*;
import java.util.*;

class Main {
	private static int N;
	private static String str;
	private static ArrayList<String> list;
	private static HashSet<String> set;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		str = br.readLine();
		
		list = new ArrayList<>(scoreBoard());        // 중복을 제거한 HashSet을 정렬하기 위해 ArrayList에 담음.
		Collections.sort(list);             // 오름차순 정렬.
	
		System.out.println(scoreMax());     // scoreBoard에서 했던거와 같이 scoreMax도 브루트포스로 검사하여 최대값을 return
	}
	
	private static HashSet<String> scoreBoard() {       	// P를 만들기 위함.
		HashSet<String> set = new HashSet<>();		// 중복 제거하기 위해 HashSet 사용. 
		
		for (int i = 1; i < N - 1; i++) {
			for(int j = i + 1; j < N; j++) {
				String first = str.substring(0, i);
				String second = str.substring(i, j);
				String third = str.substring(j);
				
				set.add(first);
				set.add(second);
				set.add(third);
			}
		}
		return set;
	}
	
	private static int scoreMax() {
		int maxScore = Integer.MIN_VALUE;
		
		for (int i = 1; i < N - 1; i++) {
			for(int j = i + 1; j < N; j++) {
				String first = str.substring(0, i);
				String second = str.substring(i, j);
				String third = str.substring(j);
				
				int score = list.indexOf(first) + 1
					+ list.indexOf(second) + 1
					+ list.indexOf(third) + 1;
				
				maxScore = Math.max(maxScore, score);
			}
		}
		return maxScore;
	}
	
}
