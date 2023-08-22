const readline = require('readline');
let rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let count = 0;
let answer = 0;
let N, K;
const M = [];
const dx = [-1, -1, -1, 0, 0, 1, 1, 1];
const dy = [-1, 0, 1, -1, 1, -1, 0, 1];

rl.on('line', (line) => {
  count++;

  if (count === 1) {
    [N, K] = line.split(' ').map(Number);
  } else {
    M.push(line.split(' ').map(Number));
  }
});

rl.on('close', () => {
  function solution(x, y) {
    let cnt = 0;

    for (let k = 0; k < 8; k++) {
      let nx = x + dx[k];
      let ny = y + dy[k];

      if (nx >= 0 && nx < N && ny >= 0 && ny < N && M[nx][ny] === 1) {
        cnt += 1;
      }
    }
    return cnt;
  }

  for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
      if (M[i][j] === 0 && solution(i, j) === K) {
        answer += 1;
      }
    }
  }

  console.log(answer);
});
