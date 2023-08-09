const input = require("fs").readFileSync("/dev/stdin").toString().split("\n").map((v) => v.split(" ").map(Number));
const [N, A, operator] = input;
let max = Number.MIN_SAFE_INTEGER;
let min = Number.MAX_SAFE_INTEGER;

const calculator = [
  (a, b) => a + b,
  (a, b) => a - b,
  (a, b) => a * b,
  (a, b) => parseInt(a / b),
];

const DFS = (cnt, result) => {
  if (cnt === N - 1) {            //연산자 갯수만큼 반복하다가 max, min 판정
    max = Math.max(max, result);
    min = Math.min(min, result);
  } else {
    for (let i = 0; i < operator.length; i++) {
      if (operator[i] === 0) {
        continue;
      };

      operator[i] -= 1;

      DFS(cnt + 1, calculator[i](result, A[cnt + 1]));

      operator[i] += 1;
    };
  };
};

DFS(0, A[0]);

console.log(max ? max : 0); // -0과 0 구분
console.log(min ? min : 0);