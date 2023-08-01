const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');
const map = input.map((v) => v.split('').map(Number));

const zero = [];

for (let i = 0; i < 9; i++) {
  for (let j = 0; j < 9; j++) {
    if (map[i][j] == 0) {
      zero.push([i, j]);
    };
  };
};

function DFS(start) {
  if (start == zero.length) {
    console.log(map.map((v) => v.join('')).join('\n'));

    process.exit();
  };

  const [x, y] = zero[start];

  for (let i = 1; i < 10; i++) {
    if (check(x, y, i)) {
      map[x][y] = i;

      DFS(start + 1);

      map[x][y] = 0;
    };
  };
};

function check(x, y, n) {
  for (let i = 0; i < 9; i++) {
    if (map[x][i] == n) {
      return false;
    };
  };

  for (let i = 0; i < 9; i++) {
    if (map[i][y] == n) {
      return false;
    };
  };

  const X = Math.floor(x / 3) * 3;
  const Y = Math.floor(y / 3) * 3;

  for (let i = X; i < X + 3; i++) {
    for (let j = Y; j < Y + 3; j++) {
      if (map[i][j] == n) {
        return false;
      }
    };
  };
  return true;
};


DFS(0);

/* 
  1. 0이 포함되어있는 수를 zero 배열에 담는다.
  2. 가로 줄 확인
  3. 세로 줄 확인
  4. 3 * 3 확인
  5. DFS를 사용해 재귀
*/