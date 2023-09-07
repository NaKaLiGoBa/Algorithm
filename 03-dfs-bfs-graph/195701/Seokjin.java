import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Seokjin {
    static int n, m, s, e;
    static boolean[] visitedCity;
    static ArrayList<ArrayList<Integer>> arrayList;

    public static void printShortestPath(int underConstructionCity) {
        if(underConstructionCity == s
                || underConstructionCity == e) {
            System.out.println(-1);
            return;
        } else {
            Queue<Integer> queue = new LinkedList<>();
            visitedCity = new boolean[n+1];
            int visitedCnt = 1;
            queue.add(s);
            visitedCity[underConstructionCity] = true;

            while(!queue.isEmpty()) {
                int size = queue.size();
                visitedCnt+=1;

                for(int i=0; i<size; i++) {
                    int curCity = queue.poll();
                    ArrayList<Integer> connectedCity = arrayList.get(curCity);

                    for(int nextCity : connectedCity) {
                        if(visitedCity[nextCity])
                            continue;

                        if(nextCity == e) { // 다음 이동할 도시가 도착 도시일 경우
                            System.out.println(visitedCnt);
                            return;
                        }

                        queue.add(nextCity);
                        visitedCity[nextCity] = true;
                    }
                }
            }

            System.out.println(-1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        s = sc.nextInt();
        e = sc.nextInt();
        visitedCity = new boolean[n+1];
        arrayList = new ArrayList<ArrayList<Integer>>();

        for(int i=0; i<=n; i++)
            arrayList.add(new ArrayList<Integer>());

        for(int i=0; i<m; i++) {
            int sCity = sc.nextInt();
            int eCity = sc.nextInt();

            arrayList.get(sCity).add(eCity);
            arrayList.get(eCity).add(sCity);
        }

        for(int i=1; i<=n; i++)
            printShortestPath(i);
    }
}