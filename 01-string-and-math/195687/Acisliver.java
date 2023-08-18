import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        List<Integer> list = Arrays.stream(br.readLine().split(" "))
                .map(Integer::valueOf)
                .sorted(Comparator.reverseOrder())
                .sorted(Comparator.comparingInt(Main::getBinaryMaskCount).reversed())
                .collect(Collectors.toList());

//        for (Integer i : list) {
//            System.out.println(Integer.toBinaryString(i) + " " + i);
//        }

        System.out.println(list.get(K - 1));
    }

    private static int getBinaryMaskCount(int number) {
        int size = 0;

        while (number > 0) {
            size += number & 1;
            number >>= 1;
        }

        return size;
    }

}


