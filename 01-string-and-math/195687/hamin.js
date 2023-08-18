const readline = require('readline');

let rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let N, K;
let cnt = 0;
let a = [];
let arr = [];

rl.on('line', (line) => {
  cnt++;
  if (cnt === 1) {
    [N, K] = line.split(' ').map(Number);
  } else {
    a = line.trim().split(' ').map(Number);
  }
});

rl.on('close', () => {
  for (const v of a) {
    let count = v.toString(2).split('1').length - 1;

    arr.push([v, count]);
  }

  arr.sort((a, b) => {
    if (a[1] === b[1]) {
      return b[0] - a[0];
    }

    return b[1] - a[1];
  });

  console.log(arr[K - 1][0]);
});
