import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> bucket = new Stack<>();
        int[] depth = new int[board[0].length];                 
        boolean[] visited = new boolean[board[0].length];

        for(int i = 0; i < board[0].length; i++) {              // ---------
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 0) {                          // board의 row값을 알고 있으면 
                    continue;                                   // 바로바로 그에 해당하는 row로 이동하게 만들기위해서 
                }else {                                         // depth라는 배열 각각 인덱스에 각 줄에 해당하는 
                    if(!visited[j]) {                           // 맨 위에 자리잡고 있는 위치를 저장하였습니다.
                        depth[j] = i;                           // 여기서 사용한 boolean은 단지 각 줄을 한번 지나치면 
                        visited[j] = true;                      // 재방문을 하지 않게하기 위함입니다.
                    }
                }  
            }
        }                                                       // -----------
         
        for(int i = 0; i < moves.length; i++) {

            if(board[0].length <= depth[moves[i] - 1]) {        // depth가 만약 밑바닥보다 더 내려갔을 경우 그 줄은 생략하기 위함입니다.
                continue;                                       
            }

            if(!bucket.isEmpty() && bucket.peek() == board[depth[moves[i] - 1]][moves[i] - 1]) {    // 스택에 비어있지 않거나 and 스택의 가장 위에 있는 값과 이번에 들어올 값이 같다면
                bucket.pop();                                   // 스택 맨위에 자리잡던 원소를 없애주고
                answer += 2;                                    // 한쌍(기존 값이랑 들어올 값)을 날려버려 결과값에 +2 를 해주었습니다.
                depth[moves[i] - 1]++;                          // row위치를 알려주는 depth 배열을 1 증가.
                continue;                   
            }
            
            bucket.push(board[depth[moves[i] - 1]][moves[i] - 1]);  // 스택이 비어있거나, 스택.peek()와 들어올 값이 같지 않으면 그냥 스택에 push
            depth[moves[i] - 1]++;
        }
        
        return answer;
    }
}