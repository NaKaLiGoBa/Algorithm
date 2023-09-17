import java.util.*;

public class Seokjin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();

        long memo[] = new long[100000 + 1];
        memo[0] = 1;
        memo[1] = 3;

        for (int i = 2; i <= value; i++)
            memo[i] = ((memo[i - 1] * 2) + memo[i - 2]) % 9901;

        System.out.println(memo[value]);
    }
}