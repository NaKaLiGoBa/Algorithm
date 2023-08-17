const readline = require('readline');

(async () => {
  let rl = readline.createInterface({ input: process.stdin });

  let isFirstLine = true;
  let N;
  let k = [];
  let sum = 0;
  let x = 0;

  for await (const line of rl) {
    if (isFirstLine) {
      N = parseInt(line); // 첫 번째 줄에서 N 값을 추출
      isFirstLine = false;
    } else {
      k = line.split(' ').map(num => parseInt(num)); // 두 번째 줄에서 k 값을 배열로 추출
      break; // 두 번째 줄을 읽은 후에는 입력 읽기를 중지
    };
  };

  let max = k.indexOf(Math.max(...k));

  for (let i = 0; i < N; i++) {
    if (i >= max) {
      x = k[i];

      if (x < k[i + 1]) {
        return console.log(0);
      };
    };

    sum += k[i];
  };

  console.log(sum);

  rl.close();
  process.exit();
})();