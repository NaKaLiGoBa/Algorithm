const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');
const [N, M] = input.shift().split(' ').map(Number)
let cards = input.join('').split(' ').map(Number);
let sum = 0;

for (let i = 0; i < N; i++) {
  for (let j = i + 1; j < N; j++) {
    for (let k = j + 1; k < N; k++) {
      temp = cards[i] + cards[j] + cards[k];

      if (temp > sum && temp <= M) {
        sum = temp;
      };
    };
  };
};

console.log(sum);
