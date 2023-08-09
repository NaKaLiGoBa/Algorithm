import java.io.*;
import java.util.*;

public class Main {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int N;
    static int[] numbers, operator;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        operator = new int[4];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        calculate(numbers[0], 1);

        System.out.println(max + "\n" + min);

    }

    private static void calculate(int num, int depth) {

        if (depth == N) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for(int i = 0; i < 4; i++) {
            if(operator[i] > 0) {
                operator[i]--;
                switch(i) {
                    case 0:
                        calculate(num + numbers[depth], depth + 1);
                        break;
                    case 1:
                        calculate(num - numbers[depth], depth + 1);
                        break;
                    case 2:
                        calculate(num * numbers[depth], depth + 1);
                        break;
                    case 3:
                        calculate(num / numbers[depth], depth + 1);
                        break;
                }
                operator[i]++;
            }

        }

    }
}


