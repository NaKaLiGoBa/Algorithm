import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Array size
        int N = Integer.parseInt(br.readLine());

        // input as an Integer Array ex. [1, 2, 1, 3, 1, 2, 1]
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N + 1];
        for (int i = 1; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // series of range of array to check if it's palindrome
        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder(); // ex. [1, 3]
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int leftLimit = Integer.parseInt(st.nextToken());
            int rightLimit = Integer.parseInt(st.nextToken());

            if (isPalindrome(numbers, leftLimit, rightLimit)) sb.append(1);
            else sb.append(0);
            if (i < M - 1) sb.append("\n"); // add enter except for the last element
        }

        System.out.println(sb.toString());

    }

    private static boolean isPalindrome(int[] numbers, int leftLimit, int rightLimit) {

        while (leftLimit <= rightLimit) {
            if(numbers[leftLimit++] != numbers[rightLimit--]) return false;
        }
        return true;
    }

}
