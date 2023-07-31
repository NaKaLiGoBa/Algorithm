function check(queen, row) {
  for (let i = 0; i < row; i++) {
    if (queen[i] === queen[row] || Math.abs(queen[i] - queen[row]) === row - i) {
      return false;
    };
  };

  return true;
};

function search(queen, row) {
  const n = queen.length;
  let cnt = 0;

  if (n === row) {
    return 1;
  };

  for (let col = 0; col < n; col++) {
    queen[row] = col;
    if (check(queen, row)) {
      cnt += search(queen, row + 1);
    };
  };

  return cnt;
};

function solution(n) {
  return search(Array.from({ length: n }, () => 0), 0);
};
