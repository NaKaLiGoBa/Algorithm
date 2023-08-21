const readline = require('readline');
let rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let cnt = 0;
let N = 0;
let S = [];
let P = [];
let arr = [];
let maxSum = 0;

rl.on('line', (line) => {
  cnt++;
  if (cnt === 1) {
    N = parseInt(line);
  } else {
    S = line.trim();
  }
});

rl.on('close', () => {
  for (let i = 0; i < N - 2; i++) {
    for (let j = i + 1; j < N - 1; j++) {
      let s1 = S.substring(0, i + 1);
      let s2 = S.substring(i + 1, j + 1);
      let s3 = S.substring(j + 1);
      arr.push([s1, s2, s3]);
    }
  }

  P = [...new Set(arr.flat())].sort();

  for (let Arr of arr) {
    let sum = 0;

    for (let s of Arr) {
      sum += P.indexOf(s) + 1;
    }

    maxSum = Math.max(maxSum, sum);
  }

  console.log(maxSum);
});
