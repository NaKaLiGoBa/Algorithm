const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');
const N = Number(input.shift());
const M = Number(input.shift());
const map = input.map(v => v.split(' ').map(Number));
const graph = [...new Array(N + 1)].map(() => []);
const visited = [...new Array(N + 1)].fill(false);
let cnt = 0;

for (const [start, end] of map) {
  graph[start].push(end);
  graph[end].push(start);
};

visited[1] = true;

function DFS(start) {
  for (let end of graph[start]) {
    if (!visited[end]) {
      visited[end] = true;
      cnt += 1;

      DFS(end);
    };
  };
};

DFS(1);

console.log(cnt);

