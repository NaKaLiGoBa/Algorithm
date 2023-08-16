const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

let T;
let cnt = 0;
let arr = [];
let sum = 0;
let answer = 0;

rl.on('line', function (line) {
  cnt++;
  if (cnt === 1) {
    T = Number(line);
  } else {
    arr.push(line.trim());
  }
}).on('close', function () {
  for (let i = 0; i < T; i++) {
    const v = arr[i].split(" ");
    const x = Number(v[0]);
    const y = Number(v[2]);
    const operator = v[1];

    switch (operator) {
      case '+':
        sum = x + y;
        break;
      case '-':
        sum = x - y;
        break;
      case '*':
        sum = x * y;
        break;
      case '/':
        sum = Math.floor(x / y);
        break;
      case '%':
        sum = x % y;
        break;
    };
    answer += sum;
  };
  console.log(answer);

  process.exit();
});
