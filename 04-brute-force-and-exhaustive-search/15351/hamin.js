const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');
const [N, M] = input.map(Number);
let arr = [];
let answer = [];

const DFS = (num) => {
  if (M === num) {
    answer.push(arr.join(' '));
    return;
  };

  for (let i = 1; i <= N; i++) {
    arr.push(i);
    DFS(num + 1);
    arr.pop();
  };
};


DFS(0);

for (v of answer) {
  console.log(v);
};