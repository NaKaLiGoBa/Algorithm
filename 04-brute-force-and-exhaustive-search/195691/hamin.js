const readline = require('readline');
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let lines = [];
rl.on('line', (line) => {
  lines.push(line);
});

rl.on('close', () => {
  const [N, K] = lines[0].split(' ').map(Number);
  const map = [];
  const coordinate = [];
  const bombMap = Array.from({ length: N }, () => Array(N).fill(0)); // 폭탄값 저장 배열 추가
  const dx = [0, 0, 0, -1, 1];
  const dy = [0, -1, 1, 0, 0];
  let maxCnt = 0;

  for (let i = 1; i <= N; i++) {
    map.push(lines[i].split(' '));
  }

  for (let i = N + 1; i < lines.length; i++) {
    coordinate.push(lines[i].split(' ').map(Number));
  }

  function solution(x, y) {
    for (let k = 0; k < 5; k++) {
      let nx = x + dx[k];
      let ny = y + dy[k];

      if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] !== '#') {
        if (map[nx][ny] === '@') {
          bombMap[nx][ny] += 2;
        } else {
          bombMap[nx][ny] += 1;
        }

        maxCnt = Math.max(maxCnt, bombMap[nx][ny]);
      }
    }
  }

  for (let i = 0; i < K; i++) {
    let [x, y] = coordinate[i];

    solution(x - 1, y - 1);
  }

  console.log(maxCnt);
});
