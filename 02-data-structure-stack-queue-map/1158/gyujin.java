import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()) - 1;           // ArrayList의 인덱스가 0부터 시작하기 때문에 -1 해줌.

        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 1; i <= N; i++) {
            list.add(i);
        }

        int plus = K;                                           // 삭제해야되는 인덱스의 크기만큼 계속 더해줄 변수.
        sb.append('<');
        while(list.size() > 1) {                                // 리스트에 원소 하나만 남을때까지 반복.

            K %= list.size();                                   // 모듈러 연산으로 크기를 줄여줌.
                                    // ex) N = 7, K = 3 일 떄, 3회 실행 시 N = 5, K = 6 이 되는데, 6 % 리스트 크기: 5를 해서 인덱스가 1을 가리키도록 함.
            sb.append(list.get(K));
            list.remove(K);                                     // 해당하는 인덱스를 삭제해줌.

            K += plus;                                          // 처음 K값을 plus 변수에 고정시키고 K에 초기 K값으로 계속 증가시켜주기 위함.

            sb.append(',').append(' ');
        }
        sb.append(list.get(0)).append('>');                     // 하나남은 리스트 원소를 StringBuilder에 저장.

        System.out.println(sb.toString());

    }
}

/*
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= N; i++) {
            queue.add(i);
        }

        sb.append('<');
        while(queue.size() > 1) {                           // 큐에 원소 하나가 남을 때까지 반복
            for(int i = 0; i < K - 1; i++) {                // 큐는 인덱스 0부터 시작하여 K-1 반복하여
                queue.offer(queue.poll());                  // K값 앞에 해당하는 값들은 뒤로 보냄.
            }
            sb.append(queue.poll()).append(", ");           // K에 해당하는 값은 가장 앞으로 오게될테니 StringBuilder에 저장 후, 삭제.
        }
        sb.append(queue.poll()).append('>');
        System.out.println(sb);
    }
}
*/