const input = require('fs').readFileSync('d.txt').toString().trim();
const arr = input.split(' ').map(Number);

let answer = [];
let queue = [];
let [n, k] = arr;
let cnt = 0;

for (let i = 1; i <= n; i++) {
  queue.push(i);
};

while (queue.length) {
  cnt += 1;

  if (cnt % k === 0) {
    answer.push(queue.shift());
  } else {
    queue.push(queue.shift());
  };
};

console.log(`<${answer.join(', ')}>`);