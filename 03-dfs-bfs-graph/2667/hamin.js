const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');
const N = Number(input.shift());
const map = input.map((v) => v.split("").map(Number));
const dx = [0, 0, -1, 1];
const dy = [-1, 1, 0, 0];
let TotalCnt = 0;
let cnt = 0;
let cntArr = [];

function DFS(x, y) {
  map[x][y] = 0; // 방문한 좌표 값을 0으로 바꿔준다.
  cnt += 1;

  for (let k = 0; k < 4; k++) { // 해당 값을 기준으로 8방향을 탐색해 1의 유무를 상하좌우로 탐색
    let nx = x + dx[k];
    let ny = y + dy[k];

    if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] === 1) { // 경계선 밖으로 벗아나지 않도록 설정
      console.log(nx, ny)
      DFS(nx, ny);  // 값이 1이면 재귀
    };
  };
};

for (let i = 0; i < N; i++) {
  for (let j = 0; j < N; j++) {
    if (map[i][j] === 1) {
      DFS(i, j);
      TotalCnt += 1;
      cntArr.push(cnt);
      cnt = 0;
    };
  };
};

console.log(TotalCnt);

cntArr.sort((a, b) => a - b);

for (const v of cntArr) {
  console.log(v);
};