const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');
const [N, M] = input.shift().split(' ').map(Number);
const edges = input.map(v => v.split(' ').map(Number));
const graph = Array.from(Array(Number(N + 1)), () => []);
const visited = Array(N + 1).fill(false);
let cnt = 0;

// 양방향 그래프로 만들기
for (const [start, end] of edges) {
  graph[start].push(end);
  graph[end].push(start);
};

const DFS = (start) => {
  let stack = [...start];

  while (stack.length) {
    let node = stack.pop();

    if (visited[node]) {
      continue;
    };

    visited[node] = true;
    stack.push(...graph[node]);
  };
};

for (let i = 1; i < graph.length; i++) {
  if (!visited[i]) {
    cnt += 1;
    DFS(graph[i]);
  };
};

console.log(cnt);
