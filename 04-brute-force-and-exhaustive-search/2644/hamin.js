const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');
const N = +input[0];
const M = +input[2];
const [x, y] = input[1].split(' ').map(Number);
const graph = [...new Array(N + 1)].map(() => []);
const visited = Array(N + 1).fill(false);
const map = [];

for (let i = 3; i < 3 + M; i++) {
  map.push(input[i].split(' ').map(Number));
};

for (const [start, end] of map) {
  graph[start].push(end);
  graph[end].push(start);
};

function DFS(x, y, cnt) {
  if (x === y) {
    console.log(cnt);

    return;
  };

  visited[x] = true;

  for (let v of graph[x]) {
    if (!visited[v]) {
      DFS(v, y, cnt + 1);
    };
  };
};

DFS(x, y, 0);

if (!visited[y]) {
  console.log(-1);
};