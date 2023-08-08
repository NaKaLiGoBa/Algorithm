// const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');
const input = require('fs').readFileSync('data.txt').toString().trim().split(' ').map((element) => Number(element));
const N = input[0];
const M = input[1];
const visited = [...new Array(N + 1)].fill(false);
let arr = [];

function DFS(cnt) {
  if (cnt === M) {
    return console.log(arr.join(" "));
  };

  for (let i = 0; i < N; i++) {
    if (!visited[i]) {
      visited[i] = true;
      arr.push(i + 1);
      DFS(cnt + 1);
      arr.pop();
      visited[i] = false;
    };
  };
};

DFS(0);
