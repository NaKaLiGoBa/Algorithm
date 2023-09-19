Last login: Tue Sep 19 11:35:48 on ttys000
➜  ~ cd ./Desktop/study/Algorithm/06
cd: no such file or directory: ./Desktop/study/Algorithm/06
➜  ~ cd ./Desktop/study/Algorithm/06-DP-LIS-BitMask
➜  06-DP-LIS-BitMask git:(gukin-han) ✗ ll
import java.io.*;
total 16
drwxr-xr-x@ 3 gukinhan  staff    96B Sep 11 07:58 12865
drwxr-xr-x@ 3 gukinhan  staff    96B Sep 14 21:02 1309
drwxr-xr-x@ 3 gukinhan  staff    96B Sep 12 19:51 1463
drwxr-xr-x@ 2 gukinhan  staff    64B Aug 29 11:03 195694
drwxr-xr-x@ 3 gukinhan  staff    96B Sep 12 09:30 2579
drwxr-xr-x@ 3 gukinhan  staff    96B Sep 13 22:06 9084
-rw-r--r--@ 1 gukinhan  staff   824B Sep 18 23:25 gukin-han.java
-rw-r--r--@ 1 gukinhan  staff   225B Jul 10 15:19 hello.html
➜  06-DP-LIS-BitMask git:(gukin-han) ✗ rm gukin-han.jav
rm: gukin-han.jav: No such file or directory
➜  06-DP-LIS-BitMask git:(gukin-han) ✗ rm gukin-han.java
➜  06-DP-LIS-BitMask git:(gukin-han) ✗ ll
total 8
drwxr-xr-x@ 3 gukinhan  staff    96B Sep 11 07:58 12865
drwxr-xr-x@ 3 gukinhan  staff    96B Sep 14 21:02 1309
drwxr-xr-x@ 3 gukinhan  staff    96B Sep 12 19:51 1463
drwxr-xr-x@ 2 gukinhan  staff    64B Aug 29 11:03 195694
drwxr-xr-x@ 3 gukinhan  staff    96B Sep 12 09:30 2579
                sb.append(memo[1]);
                sb.append("\n");
drwxr-xr-x@ 3 gukinhan  staff    96B Sep 13 22:06 9084
-rw-r--r--@ 1 gukinhan  staff   225B Jul 10 15:19 hello.html
➜  06-DP-LIS-BitMask git:(gukin-han) ✗ mkdir 9251
➜  06-DP-LIS-BitMask git:(gukin-han) ✗ cd 9251
➜  9251 git:(gukin-han) ✗ vi gukin-han.java
➜  9251 git:(gukin-han) ✗ git add gukin-han.java
➜  9251 git:(gukin-han) ✗ git commit -m "[국인] LCS"
[gukin-han ae13fcc] [국인] LCS
 1 file changed, 22 insertions(+)
 create mode 100644 06-DP-LIS-BitMask/9251/gukin-han.java
➜  9251 git:(gukin-han) ✗ git push
Enumerating objects: 6, done.
Counting objects: 100% (6/6), done.
Delta compression using up to 8 threads
Compressing objects: 100% (3/3), done.
Writing objects: 100% (4/4), 391 bytes | 391.00 KiB/s, done.
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] memo = new int[n + 1];

            memo[1] = 1;
            if (n == 1) {
                sb.append(memo[1]);
                sb.append("\n");
                continue;
            }

            memo[2] = 2;
            if (n == 2) {
                sb.append(memo[2]);
                sb.append("\n");
"gukin-han.java" 46L, 1311Bimport java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] memo = new int[n + 1];

            memo[1] = 1;
            if (n == 1) {
                sb.append(memo[1]);
                sb.append("\n");
                continue;
            }

            memo[2] = 2;
            if (n == 2) {
                sb.append(memo[2]);
                sb.append("\n");
                continue;
            }

            memo[3] = 4;
            if (n == 3) {
                sb.append(memo[3]);
                sb.append("\n");
                continue;
            }

            for (int j = 4; j < memo.length; j++) {
                
                int caseOne = memo[j - 1];
                int caseTwo = memo[j - 2];
                int caseThree = memo[j - 3];
                memo[j] = caseOne + caseTwo + caseThree;
            }
            sb.append(memo[n]);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
