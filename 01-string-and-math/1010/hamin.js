let fs = require('fs');
// let input = fs.readFileSync('/dev/stdin').toString().split('\n');
let input = fs.readFileSync('data.txt').toString().split('\n');

function factorial(n) {
  if (n === 1) {
    return 1;
  }

  return n * factorial(n - 1);
};

for (let i = 1; i <= input[0]; i++) {
  let arr = input[i].split(' ').map(Number);
  let left = arr[0];
  let right = arr[1];

  if (left === right) {
    console.log(1);
    continue;
  };

  console.log(factorial(right) / (factorial(left) * factorial(right - left)));
};
