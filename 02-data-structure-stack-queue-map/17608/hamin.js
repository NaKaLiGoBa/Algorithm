const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');

let [_, ...stack] = input;
stack = stack.map(Number);

let num = 0;
let cnt = 0;
let max = 0;

while (stack.length !== 0) {
  num = stack.pop();

  if (num > max) {
    max = num;
    cnt += 1;
  };
};

console.log(cnt);