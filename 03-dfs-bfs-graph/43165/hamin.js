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