const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');
const [N, M] = input.shift().split(' ').map(Number);
const map = input.map((v) => v.split('').map(Number));
const dx = [0, 0, -1, 1];
const dy = [-1, 1, 0, 0];

function BFS() {
  let queue = [[0, 0, 1]];

  while (queue.length) {
    let [y, x, cnt] = queue.shift();

    if (N - 1 === y && M - 1 === x) {
      return cnt;
    };

    for (let i = 0; i < 4; i++) {
      let ny = y + dy[i];
      let nx = x + dx[i];

      if (ny >= 0 && ny < N && nx >= 0 && nx < M && map[ny][nx] === 1) {
        map[ny][nx] = 0;
        queue.push([ny, nx, cnt + 1]);
      };
    };
  };
};

console.log(BFS());
