// https://school.programmers.co.kr/learn/courses/30/lessons/12953
// 유클리드 호제법 => 최대공약수를 구는 알리즘

function gcd(a, b) {
  if (b === 0) return a;


  return gcd(b, a % b);
};

function solution(arr) {
  let answer = [...arr];

  while (answer.length >= 2) {
    let x = answer.pop();
    let y = answer.pop();

    answer.push((x * y) / gcd(x, y));
  }
  return +answer.join('');
};
