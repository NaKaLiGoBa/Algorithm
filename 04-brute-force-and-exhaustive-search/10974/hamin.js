const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');
const N = parseInt(input.join());
const visited = Array(N).fill(false);
let arr = [];

function DFS(cnt) {
  if (cnt === N) {
    return console.log(arr.join(' '));
  };

  for (let i = 0; i < N; i++) {
    if (!visited[i]) {
      visited[i] = true;
      arr.push(i + 1);
      DFS(cnt + 1);
      visited[i] = false;
      arr.pop();
    };
  };
};

DFS(0);