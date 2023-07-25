function solution(numbers, target) {
  let cnt = 0;

  function DFS(level, total) {
    if (level === numbers.length) {
      if (total === target) {
        cnt += 1;
      };

      return;
    };

    DFS(level + 1, total + numbers[level]);
    DFS(level + 1, total - numbers[level]);
  };

  DFS(0, 0);

  return cnt;
};

// 질문하기를 참고해서 풀었습니다.
// 깊이 우선 탐색(DFS) 알고리즘을 사용했습니다. 처음에 끝에 있는 level까지 들어가면서 +의 경우를 모두 탐색하고
// 호출된 재귀 함수를 순서대로 종료되면 -를 탐색하는 재귀함수를 실행시켜 target과 일치하면 total 값을 찾아줬습니다.