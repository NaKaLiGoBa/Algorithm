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